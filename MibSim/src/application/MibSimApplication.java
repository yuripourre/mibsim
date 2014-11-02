package application;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.etyllica.layer.ImageLayer;
import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.model.map.GeoMap;
import br.com.mibsim.view.BeingDrawer;
import br.com.mibsim.view.FountainDrawer;

public class MibSimApplication extends Application {

	private boolean drawRadius = true;

	private boolean drawGrid = true;

	private boolean paused = false;

	public static final int TILE_SIZE = 48;

	private ImageLayer sand;

	protected List<BeingDrawer> beings = new ArrayList<BeingDrawer>();

	protected GeoMap geoMap = new GeoMap();

	protected List<FountainDrawer> fountains = new ArrayList<FountainDrawer>();

	protected BeingDrawer picked;

	protected BeingDrawer underMouse;

	private int width = 60;
	private int height = 60;

	private int mapX = 0;
	private int mapY = 0;

	public MibSimApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		sand = new ImageLayer("sand.png");

		updateAtFixedRate(500);
	}

	@Override
	public void timeUpdate(long now) {

		if(!paused) {

			for(BeingDrawer being: beings) {

				if(picked != being) {
					being.getBeing().react();
				}

				for(FountainDrawer fountain: fountains) {
					//Recover Fountain
					if(being.getLayer().colideRetangular(fountain.getLayer())) {
						being.getBeing().consume(fountain.getFountain());
						break;
					}
				}

			}
		}
	}

	@Override
	public void draw(Graphic g) {

		drawMapTiles(g);
		drawGrid(g);

		drawGeoMap(g);
		drawBeings(g);

		if(underMouse != null){
			underMouse.drawEnergyBar(g);
		}

	}

	private void drawMapTiles(Graphic g) {

		for(int j = 0;j < height; j++) {
			for(int i = 0;i < width; i++) {
				sand.setCoordinates(i*TILE_SIZE, j*TILE_SIZE);
				sand.draw(g);
			}
		}

	}

	private void drawGrid(Graphic g) {
		if(!drawGrid) {
			return;
		}

		g.setColor(Color.BLACK);

		for(int j=0;j<height;j++) {
			for(int i=0;i<width;i++) {			
				g.drawRect(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}

	}

	private void drawGeoMap(Graphic g) {

		Map<Integer, Map<Integer,List<Fountain>>> map = geoMap.getMap();

		for(Map<Integer,List<Fountain>> xMap: map.values()) {

			for(List<Fountain> concepts: xMap.values()) {

				for(Fountain concept: concepts){
					//concept.draw(g);
				}
			}			
		}

	}	

	private void drawBeings(Graphic g) {

		if(drawRadius) {
			for(BeingDrawer being: beings) {
				being.drawInteractionRadius(g);
			}
		}

		for(BeingDrawer being: beings) {
			being.draw(g);
		}

	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		if(event.isKeyDown(KeyEvent.TSK_SETA_DIREITA)) {
			//if(mapX>0) {
				mapX--;
				offsetMap(-1, 0);
				//}			
		}

		if(event.isKeyDown(KeyEvent.TSK_SETA_ESQUERDA)) {
			//if(mapX<MAP_WIDTH) {
			mapX++;
			offsetMap(+1, 0);
			//}

		}

		if(event.isKeyDown(KeyEvent.TSK_SETA_BAIXO)) {
			//if(mapY>0) {
			mapY--;
			offsetMap(0, -1);
			//}

		}

		if(event.isKeyDown(KeyEvent.TSK_SETA_CIMA)) {
			//if(mapY<MAP_HEIGHT) {
			mapY++;
			offsetMap(0, +1);
			//}

		}

		if(event.isKeyDown(KeyEvent.TSK_H)) {
			drawRadius = !drawRadius;
		}

		if(event.isKeyDown(KeyEvent.TSK_P)) {
			paused = !paused;
		}

		if(event.isKeyDown(KeyEvent.TSK_G)) {
			drawGrid = !drawGrid;
		}

		return null;
	}

	protected void offsetMap(int offsetX, int offsetY) {

		for(BeingDrawer being: beings) {
			being.getLayer().setOffset(offsetX, offsetY);
		}

		for(FountainDrawer fountain: fountains) {
			fountain.getLayer().setOffset(offsetX, offsetY);
		}

	}

	int dragX = 0;
	int dragY = 0;

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		underMouse = null;

		for(BeingDrawer being: beings) {
			if(being.getLayer().onMouse(event)) {
				being.setOnMouse(true);
				underMouse = being;
			}else{
				being.setOnMouse(false);
			}
		}

		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_LEFT)) {

			if(underMouse!=null) {
				picked = underMouse;
			}else{
				picked = null;
			}

		}

		if(event.isButtonUp(MouseButton.MOUSE_BUTTON_LEFT)) {
			picked = null;
		}


		if(picked!=null) {
			picked.getLayer().setX(event.getX()-TILE_SIZE/2);
			picked.getLayer().setY(event.getY()-TILE_SIZE/2);
		}

		return GUIEvent.NONE;
	}

}

