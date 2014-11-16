package br.com.mibsim.application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.mibsim.building.basement.Basement;
import br.com.mibsim.building.basement.BlueBasement;
import br.com.mibsim.building.basement.RedBasement;
import br.com.mibsim.specie.BlueLurker;
import br.com.mibsim.specie.GreenUltralisk;
import br.com.mibsim.specie.RedHydralisk;
import br.com.mibsim.specie.Specie;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;
import br.com.vite.export.MapExporter;
import br.com.vite.map.Map;

public class AnotherSimulator extends Application {

	private Controller controller;
	
	private Specie bug;
	
	private Map map;
	
	private Basement basement;
	
	private boolean paused = false; 
	
	private List<Specie> bugs = new ArrayList<Specie>();
	
	public AnotherSimulator(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		
		basement = new RedBasement(300, 300);
		
		//bug = new BlueLurker(100, 200);
		//bug = new GreenUltralisk(100, 200);		
		
		bug = new RedHydralisk(100, 200, basement);
				
		generateRandomCreatures();
				
		controller = new EasyController(bug);
		
		try {
			map = MapExporter.loadMap("map1.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateAtFixedRate(50);
		
		loading = 100;
	}
	
	private void generateRandomCreatures() {
		
		System.out.println("Generate Creatures!");
		
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
		
			int x = random.nextInt(w);
			int y = random.nextInt(h);
			
			Specie bug = new RedHydralisk(x, y, basement);
			
			System.out.println("Generate bug at: "+x+" "+y);
			
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
	
	@Override
	public void draw(Graphic g) {
		map.draw(g);
		bug.draw(g);
		basement.draw(g);
		
		for(Specie bug: bugs) {
			bug.draw(g);
			bug.drawHealthBar(g);
		}
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		controller.handleEvent(event);
		
		if(event.isKeyDown(KeyEvent.TSK_SPACE)) {
			paused = !paused;
		}
		
		return null;
	}

}
