package application;

import geo.GeoMap;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.application.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyboardEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.event.Tecla;
import br.com.etyllica.core.video.Grafico;
import concept.being.Being;
import concept.being.creature.BlueCreature;
import concept.being.creature.RedCreature;
import concept.being.creature.YellowCreature;
import concept.nutrient.FoodFountain;
import concept.nutrient.WaterFountain;

public class SimApplication extends Application{

	private int width = 60;
	private int height = 60;
	private int tileSize = 16;
	private boolean drawRadius = true;
	
	private List<Being> beings;
	
	private GeoMap geomap;

	public SimApplication(int w, int h) {
		super(w, h);
	}


	@Override
	public void load() {
		
		geomap = new GeoMap();

		generateRiver();
		generateFood();

		beings = new ArrayList<Being>();
		beings.add(new RedCreature(16,6));
		beings.add(new RedCreature(10,7));
		beings.add(new YellowCreature(38,19));
		beings.add(new YellowCreature(35,22));
		beings.add(new YellowCreature(36,28));
		beings.add(new BlueCreature(10,7));

		for(Being being: beings){
			being.getGeomap().add(wf);
		}

		updateAtFixedRate(700);

		loading = 100;
	}
	
	private WaterFountain wf = new WaterFountain(4,4);
	
	private void generateRiver(){
		
		geomap.add(new WaterFountain(0,3));
		geomap.add(new WaterFountain(1,3));
		geomap.add(new WaterFountain(2,3));
		geomap.add(new WaterFountain(3,3));
		geomap.add(new WaterFountain(4,3));
		geomap.add(new WaterFountain(5,3));
		
		geomap.add(wf);
		geomap.add(new WaterFountain(5,5));		
	}
	
	private void generateFood(){
		
		geomap.add(new FoodFountain(2,9));
		geomap.add(new FoodFountain(3,9));
		geomap.add(new FoodFountain(4,9));
		
		geomap.add(new FoodFountain(2,10));
		geomap.add(new FoodFountain(3,10));
		geomap.add(new FoodFountain(4,10));		
		
	}

	@Override
	public void timeUpdate(){
		for(Being being: beings){
			being.live();
		}
	}

	@Override
	public void draw(Grafico g) {

		g.setColor(Color.GREEN);
		for(int j=0;j<height;j++){
			for(int i=0;i<width;i++){
				g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
			}
		}

		g.setColor(Color.BLACK);
		for(int j=0;j<height;j++){
			for(int i=0;i<width;i++){			
				g.drawRect(i*tileSize, j*tileSize, tileSize, tileSize);
			}
		}

		drawMap(g);
		drawBeings(g);

	}

	private void drawMap(Grafico g){
		geomap.draw(g);
	}	

	private void drawBeings(Grafico g){
		if(drawRadius){
			for(Being being: beings){
				being.drawInteractionRadius(g);
			}
		}
		for(Being being: beings){
			being.draw(g);
		}		
	}

	@Override
	public GUIEvent updateKeyboard(KeyboardEvent event) {
		
		if(event.getPressed(Tecla.TSK_H)){
			drawRadius = !drawRadius;
		}
		
		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}

