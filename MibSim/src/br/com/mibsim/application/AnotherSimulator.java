package br.com.mibsim.application;

import java.io.FileNotFoundException;

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
	
	private Basement blueBasement;
	
	public AnotherSimulator(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
				
		//bug = new BlueLurker(100, 200);
		//bug = new GreenUltralisk(100, 200);
		bug = new RedHydralisk(100, 200);
		
		blueBasement = new RedBasement(300, 300);
		
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
	
	@Override
	public void timeUpdate(long now) {		
		bug.update(now);
	}
	
	@Override
	public void draw(Graphic g) {
		map.draw(g);
		bug.draw(g);
		blueBasement.draw(g);
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		controller.handleEvent(event);
		
		return null;
	}

}
