package br.com.mibsim.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.util.kdtree.KDTree;
import br.com.etyllica.util.kdtree.KeyDuplicateException;
import br.com.etyllica.util.kdtree.KeySizeException;
import br.com.mibsim.building.basement.HydraliskBasement;
import br.com.mibsim.building.basement.LurkerBasement;
import br.com.mibsim.building.basement.UltraliskBasement;
import br.com.mibsim.editor.ZergGrid;
import br.com.mibsim.model.fountain.AdamantiteFountain;
import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.model.fountain.WaterFountain;
import br.com.mibsim.specie.Hydralisk;
import br.com.mibsim.specie.Lurker;
import br.com.mibsim.specie.Speciemen;
import br.com.mibsim.specie.Ultralisk;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;

public class AnotherSimulator extends Application {

	private Controller controller;

	private Speciemen bug;

	private int offsetX = 0;
	private int offsetY = 0;

	private HydraliskBasement redBasement;
	private UltraliskBasement greenBasement;
	private LurkerBasement blueBasement;

	private boolean paused = false;

	private List<Speciemen> bugs = new ArrayList<Speciemen>();
	private List<Fountain> fountains = new ArrayList<Fountain>();
	private KDTree<Fountain> fountainsTree = new KDTree<Fountain>(2);

	private ZergGrid floor;

	private boolean drawSensors = true;
	private boolean drawHealthBar = true;	

	public AnotherSimulator(int w, int h) {
		super(w, h);

		//paused = true;
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

		System.out.println("Generating Creatures!");

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

		System.out.println("Generating Fountains!");

		try {

			addWaterFountain(300,400);
			addAdamantiteFountain(700, 400);

		} catch (KeySizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addWaterFountain(int x, int y) throws KeySizeException, KeyDuplicateException {

		double[] key = new double[2];
		key[0] = x;
		key[1] = y;

		Fountain fountain = new WaterFountain(x, y);

		fountainsTree.insert(key, fountain);
		fountains.add(fountain);
	}

	private void addAdamantiteFountain(int x, int y) throws KeySizeException, KeyDuplicateException {
		double[] key = new double[2];
		key[0] = x;
		key[1] = y;

		Fountain fountain = new AdamantiteFountain(x, y);

		fountainsTree.insert(key, fountain);
		fountains.add(fountain);
	}

	@Override
	public void timeUpdate(long now) {

		if(paused)
			return;

		updateBugs(now);
	}

	private void updateBugs(long now) {

		for(Speciemen bug: bugs) {
			bug.update(now);

			double[] key = bug.getPositionAsArray();

			double radius = bug.getSensorRadius();

			try {
				List<Fountain> found = fountainsTree.nearestEuclidean(key, radius);

				for(Fountain fountain: found) {
					bug.discovered(fountain);	
				}

			} catch (KeySizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void draw(Graphic g) {

		//g.setCamera(extendedCamera);

		//map.draw(g);
		//map.getMap().draw(g, 0, 0, 32, 28);
		floor.draw(g);

		drawFountains(g);
		
		drawSpeciemens(g);		

		redBasement.draw(g, offsetX, offsetY);
		greenBasement.draw(g, offsetX, offsetY);
		blueBasement.draw(g, offsetX, offsetY);

		//g.resetCamera(extendedCamera);
		//extendedCamera.draw(g);
	}

	private void drawSpeciemens(Graphic g) {
		if(drawSensors) {
			for(Speciemen bug: bugs) {
				bug.drawSensors(g, offsetX, offsetY);
			}
		}

		for(Speciemen bug: bugs) {	
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
