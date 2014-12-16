package br.com.mibsim.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.mibsim.building.basement.BlueBasement;
import br.com.mibsim.building.basement.GreenBasement;
import br.com.mibsim.building.basement.RedBasement;
import br.com.mibsim.editor.ZergGrid;
import br.com.mibsim.specie.BlueLurker;
import br.com.mibsim.specie.GreenUltralisk;
import br.com.mibsim.specie.RedHydralisk;
import br.com.mibsim.specie.Speciemen;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;

public class AnotherSimulator extends Application {

	private Controller controller;

	private Speciemen bug;

	private RedBasement redBasement;
	private GreenBasement greenBasement;
	private BlueBasement blueBasement;

	private boolean paused = true;

	private List<Speciemen> bugs = new ArrayList<Speciemen>();
	
	private ZergGrid floor;
	
	public AnotherSimulator(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		redBasement = new RedBasement(320, 32*10);
		greenBasement = new GreenBasement(32*20, 32*3);
		blueBasement = new BlueBasement(32*15, 32*3);

		//bug = new BlueLurker(100, 200);
		//bug = new GreenUltralisk(100, 200);		

		bug = new RedHydralisk(100, 200, redBasement);
		bugs.add(bug);
		
		generateRandomCreatures(40);		

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

			Speciemen bug = new RedHydralisk(x, y, redBasement);

			if(specie == 1) {
				bug = new GreenUltralisk(x, y, greenBasement);
			} else if(specie == 2) {
				bug = new BlueLurker(x, y, blueBasement);
			}

			float angle = random.nextInt(360);

			bug.setStartAngle(angle);

			bugs.add(bug);
		}
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

		for(Speciemen bug: bugs) {
			bug.drawSensors(g, offsetX, offsetY);
		}
		
		for(Speciemen bug: bugs) {	
			bug.draw(g, offsetX, offsetY);
			bug.drawHealthBar(g, offsetX, offsetY);
		}

		redBasement.draw(g, offsetX, offsetY);
		greenBasement.draw(g, offsetX, offsetY);
		blueBasement.draw(g, offsetX, offsetY);

		//g.resetCamera(extendedCamera);
		//extendedCamera.draw(g);
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

		return null;
	}

	public void translate(int x, int y) {

		offsetX += x;
		offsetY += y;
				
		floor.translate(x, y);
	}

}
