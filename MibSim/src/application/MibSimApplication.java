package application;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import map.GeoMap;
import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.ImageLayer;
import concept.Concept;
import concept.Fountain;
import concept.being.Being;
import concept.being.creature.BlueCreature;
import concept.being.creature.RedCreature;
import concept.being.creature.YellowCreature;
import concept.nutrient.AdamantiteFountain;
import concept.nutrient.SugarFountain;
import concept.nutrient.WaterFountain;

public class MibSimApplication extends Application{

	private ImageLayer sand;

	private final int MAP_WIDTH = 800;
	private final int MAP_HEIGHT = 800;

	private int mapX = 0;
	private int mapY = 0;

	private int width = 60;
	private int height = 60;

	private int TILE_SIZE = Fountain.TILE_SIZE;

	private boolean drawRadius = true;

	private boolean paused = false;

	private boolean grid = true;

	private List<Being> beings;

	private GeoMap geomap;

	private List<Concept> fountains = new ArrayList<Concept>();	

	private Being picked;

	private Being underMouse;	

	public MibSimApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		geomap = new GeoMap();

		generateRiver();
		generateFood();
		geomap.addAll(fountains);

		beings = new ArrayList<Being>();
		beings.add(new RedCreature(160,60));
		beings.add(new RedCreature(190,70));
		beings.add(new YellowCreature(380,190));
		beings.add(new YellowCreature(350,220));
		beings.add(new YellowCreature(360,280));
		beings.add(new BlueCreature(170,90));

		Random rand = new Random();

		for(Being being: beings){
			being.getGeomap().add(fountains.get(rand.nextInt(fountains.size())));
		}

		sand = new ImageLayer("sand.png");

		updateAtFixedRate(500);

		mapX = -mapX;
		mapY = -mapY;
		offsetMap();

		loading = 100;
	}

	private void generateRiver(){

		fountains.add(new WaterFountain(100,30));
		fountains.add(new WaterFountain(210,30));
		fountains.add(new WaterFountain(320,30));
		fountains.add(new WaterFountain(430,30));
		fountains.add(new WaterFountain(540,30));
		fountains.add(new WaterFountain(650,30));
		fountains.add(new WaterFountain(750,50));

	}

	private void generateFood(){

		fountains.add(new SugarFountain(120,90));
		fountains.add(new SugarFountain(250,90));
		fountains.add(new SugarFountain(380,90));

		fountains.add(new SugarFountain(120,300));
		fountains.add(new SugarFountain(250,200));
		fountains.add(new SugarFountain(390,500));		
		
		fountains.add(new AdamantiteFountain(200,520));
		fountains.add(new AdamantiteFountain(250,490));
		fountains.add(new AdamantiteFountain(310,590));

	}

	@Override
	public void timeUpdate(long now) {

		if(!paused){

			for(Being being: beings){

				if(picked!=being){
					being.react();
				}

				for(Fountain fountain: fountains){
					//Recover Fountain
					if(being.colideRetangular(fountain)){
						being.consume(fountain);
						break;
					}
				}

			}
		}
	}

	@Override
	public void draw(Graphic g) {

		g.setColor(Color.GREEN);
		for(int j=0;j<height;j++){
			for(int i=0;i<width;i++){
				sand.setCoordinates(i*TILE_SIZE, j*TILE_SIZE);
				sand.draw(g);
				//g.fillRect(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}

		if(grid){
			g.setColor(Color.BLACK);
			for(int j=0;j<height;j++){
				for(int i=0;i<width;i++){			
					g.drawRect(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
			}
		}

		drawMap(g);
		drawBeings(g);

	}

	private void drawMap(Graphic g){
		geomap.draw(g);
	}	

	private void drawBeings(Graphic g){
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
	public GUIEvent updateKeyboard(KeyEvent event) {

		if(event.isKeyDown(KeyEvent.TSK_SETA_DIREITA)){
			//if(mapX>0){
			mapX--;
			offsetMap();
			//}			
		}

		if(event.isKeyDown(KeyEvent.TSK_SETA_ESQUERDA)){
			//if(mapX<MAP_WIDTH){
			mapX++;
			offsetMap();
			//}

		}

		if(event.isKeyDown(KeyEvent.TSK_SETA_BAIXO)){
			//if(mapY>0){
			mapY--;
			offsetMap();
			//}

		}

		if(event.isKeyDown(KeyEvent.TSK_SETA_CIMA)){
			//if(mapY<MAP_HEIGHT){
			mapY++;
			offsetMap();
			//}

		}

		if(event.isKeyDown(KeyEvent.TSK_H)){
			drawRadius = !drawRadius;
		}

		if(event.isKeyDown(KeyEvent.TSK_P)){
			paused = !paused;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_G)){
			grid = !grid;
		}

		return null;
	}

	private void offsetMap(){

		for(Being being: beings){
			being.setMapX(mapX);
			being.setMapY(mapY);
		}

		for(Concept fountain: fountains){
			fountain.setMapX(mapX);
			fountain.setMapY(mapY);
		}

	}

	int dragX = 0;
	int dragY = 0;

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		underMouse = null;

		for(Being being: beings){
			if(being.onMouse(event)){
				being.setOnMouse(true);
				underMouse = being;
			}else{
				being.setOnMouse(false);
			}
		}

		if(event.onButtonDown(MouseButton.MOUSE_BUTTON_LEFT)){

			if(underMouse!=null){
				picked = underMouse;
			}else{
				picked = null;
			}

		}

		if(event.onButtonUp(MouseButton.MOUSE_BUTTON_LEFT)){

			picked = null;			

		}


		if(picked!=null){
			picked.setX(event.getX()-TILE_SIZE/2);
			picked.setY(event.getY()-TILE_SIZE/2);
		}

		// TODO Auto-generated method stub
		return null;
	}

}

