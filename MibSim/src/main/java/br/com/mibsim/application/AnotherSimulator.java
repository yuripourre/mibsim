package br.com.mibsim.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.mibsim.building.basement.LurkerBasement;
import br.com.mibsim.building.basement.UltraliskBasement;
import br.com.mibsim.building.basement.HydraliskBasement;
import br.com.mibsim.editor.ZergGrid;
import br.com.mibsim.model.fountain.AdamantiteFountain;
import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.model.fountain.WaterFountain;
import br.com.mibsim.specie.Lurker;
import br.com.mibsim.specie.Ultralisk;
import br.com.mibsim.specie.Hydralisk;
import br.com.mibsim.specie.Speciemen;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;

public class AnotherSimulator extends Application {

	private Controller controller;

	private Speciemen bug;

	private HydraliskBasement redBasement;
	private UltraliskBasement greenBasement;
	private LurkerBasement blueBasement;

	private boolean paused = true;

	private List<Speciemen> bugs = new ArrayList<Speciemen>();
	private List<Fountain> fountains = new ArrayList<Fountain>();
	
	private ZergGrid floor;
	
	private boolean drawSensors = true;
	private boolean drawHealthBar = true;	
	
	public AnotherSimulator(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		redBasement = new HydraliskBasement(320, 32*10);
		greenBasement = new UltraliskBasement(32*20, 32*3);
		blueBasement = new LurkerBasement(32*15, 32*3);

		//bug = new BlueLurker(100, 200);
		//bug = new GreenUltralisk(100, 200);		

		bug = new Hydralisk(100, 200, redBasement);
		bugs.add(bug);
		
		generateRandomCreatures(40);
		
		generateFountains();

		controller = new EasyController(bug);
				
		floor = new ZergGrid(w, h);
		
		updateAtFixedRate(50);

		loading = 100;
	}

	private void generateRandomCreatures(int quantity) {
		
		System.out.println("Generate Creatures!");

		Random random = new Random();

		for(int i = 0; i < quantity; i++) {

			int x = random.nextInt(w*2);
			int y = random.nextInt(h*2);

			int specie = random.nextInt(3);

			Speciemen bug = new Hydralisk(x, y, redBasement);

			if(specie == 1) {
				bug = new Ultralisk(x, y, greenBasement);
			} else if(specie == 2) {
				bug = new Lurker(x, y, blueBasement);
			}

			float angle = random.nextInt(360);

			bug.setStartAngle(angle);

			bugs.add(bug);
		}
	}
	
	private void generateFountains() {
		fountains.add(new WaterFountain(300, 400));
		
		fountains.add(new AdamantiteFountain(700, 400));
	}

	@Override
	public void timeUpdate(long now) {

		if(paused)
			return;

		for(Speciemen bug: bugs) {
			bug.update(now);
		}

	}

	int cx = 0;
	
	int offsetX = 0;
	int offsetY = 0;

	@Override
	public void draw(Graphic g) {
		
		//g.setCamera(extendedCamera);

		//map.draw(g);
		//map.getMap().draw(g, 0, 0, 32, 28);
		floor.draw(g);
				
		drawSpeciemens(g);
		drawFountains(g);

		redBasement.draw(g, offsetX, offsetY);
		greenBasement.draw(g, offsetX, offsetY);
		blueBasement.draw(g, offsetX, offsetY);

		//g.resetCamera(extendedCamera);
		//extendedCamera.draw(g);
	}
	
	private void drawSpeciemens(Graphic g) {
		for(Speciemen bug: bugs) {
			if(drawSensors)
				bug.drawSensors(g, offsetX, offsetY);
			
			bug.draw(g, offsetX, offsetY);
			
			if(drawHealthBar)
				bug.drawHealthBar(g, offsetX, offsetY);
		}
	}
	
	private void drawFountains(Graphic g) {
		for(Fountain fountain: fountains) {
			fountain.draw(g, offsetX, offsetY);
		}
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		//controller.handleEvent(event);

		if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {
			translate(-20, 0);
		}

		if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {
			translate(20, 0);
		}

		if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			translate(0, 20);
		}

		if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {
			translate(0, -20);
		}

		if(event.isKeyDown(KeyEvent.TSK_SPACE)) {
			paused = !paused;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_S)) {
			drawSensors = !drawSensors;	
		}
		
		if(event.isKeyDown(KeyEvent.TSK_H)) {
			drawHealthBar = !drawHealthBar;	
		}

		return null;
	}

	public void translate(int x, int y) {

		offsetX += x;
		offsetY += y;
				
		floor.translate(x, y);
	}

}
