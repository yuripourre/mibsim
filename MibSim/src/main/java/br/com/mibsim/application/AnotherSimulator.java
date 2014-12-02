package br.com.mibsim.application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.etyllica.cinematics.Camera;
import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.mibsim.building.basement.BlueBasement;
import br.com.mibsim.building.basement.GreenBasement;
import br.com.mibsim.building.basement.RedBasement;
import br.com.mibsim.specie.BlueLurker;
import br.com.mibsim.specie.GreenUltralisk;
import br.com.mibsim.specie.RedHydralisk;
import br.com.mibsim.specie.Specie;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;
import br.com.vite.editor.MapEditor;
import br.com.vite.export.MapExporter;

public class AnotherSimulator extends Application {

	private Camera extendedCamera;

	private Controller controller;

	private Specie bug;

	private MapEditor map;

	private RedBasement redBasement;
	private GreenBasement greenBasement;
	private BlueBasement blueBasement;

	private boolean paused = false;

	private List<Specie> bugs = new ArrayList<Specie>();

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

		generateRandomCreatures();

		controller = new EasyController(bug);

		try {
			map = MapExporter.load("map1.json");
			map.disableCollisionShow();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//extendedCamera = new Camera(0, 0, map.getColumns()*map.getTileWidth(), map.getLines()*map.getTileHeight());
		extendedCamera = new Camera(0, 0, w*2, h*2);

		updateAtFixedRate(50);

		loading = 100;
	}

	private void generateRandomCreatures() {

		System.out.println("Generate Creatures!");

		Random random = new Random();

		for(int i = 0; i < 10*10; i++) {

			int x = random.nextInt(w*2);
			int y = random.nextInt(h*2);

			int specie = random.nextInt(3);

			Specie bug = new RedHydralisk(x, y, redBasement);

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

		bug.update(now);

		for(Specie bug: bugs) {
			bug.update(now);
		}

	}

	int cx = 0;

	@Override
	public void draw(Graphic g) {

		g.setCamera(extendedCamera);

		//map.draw(g);
		map.getMap().draw(g, 0, 0, 32, 28);
		bug.drawSensors(g);
		bug.draw(g);
		bug.drawHealthBar(g);

		for(Specie bug: bugs) {
			bug.drawSensors(g);
		}
		
		for(Specie bug: bugs) {	
			bug.draw(g);
			bug.drawHealthBar(g);
		}

		redBasement.draw(g);
		greenBasement.draw(g);
		blueBasement.draw(g);

		g.resetCamera(extendedCamera);
		extendedCamera.draw(g);
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		controller.handleEvent(event);

		if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {
			translate(20, 0);
		}

		if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {
			translate(-20, 0);
		}

		if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			translate(0, -20);
		}

		if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {
			translate(0, 20);
		}

		if(event.isKeyDown(KeyEvent.TSK_SPACE)) {
			paused = !paused;
		}

		return null;
	}

	public void translate(int x, int y) {

		extendedCamera.setAimX(extendedCamera.getAimX()+x);
		extendedCamera.setAimY(extendedCamera.getAimY()+y);

	}

}
