package concept;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.ImageLayer;

public abstract class Concept extends Fountain{

	private ImageLayer layer;
	
	protected boolean onMouse = false;
	
	protected int mapX = 0;
	protected int mapY = 0;
	
	public Concept(int x, int y) {
		super(x,y);
	}
	
	public Concept(int x, int y, String imagePath) {
		super(x, y);
		this.layer = new ImageLayer(imagePath);
	}

	protected Color colorFill = Color.GREEN;
	protected Color colorDraw = Color.BLACK;
	
	@Override
	public void draw(Graphic g){
		
		if(drained){
			g.setOpacity(50);
		}
		
		layer.setCoordinates(x+mapX*TILE_SIZE, y+mapY*TILE_SIZE);
		layer.draw(g);
		
	}
	
	@Override
	public boolean onMouse(int mx, int my) {

		if(mx + 1 < x+mapX*TILE_SIZE)	return false;
		if(mx > x+mapX*TILE_SIZE + xTile)	return false;

		if(my + 1 < y+mapY*TILE_SIZE)	return false;
		if(my > y+mapY*TILE_SIZE + yTile)	return false;

		return true;

	}

	public boolean isOnMouse() {
		return onMouse;
	}

	public void setOnMouse(boolean onMouse) {
				
		this.onMouse = onMouse;

		if(!onMouse){
			colorDraw = Color.BLACK;
		}else{			
			colorDraw = Color.WHITE;
		}
		
	}

	public void setMapX(int mapX) {
		this.mapX = mapX;
	}

	public void setMapY(int mapY) {
		this.mapY = mapY;
	}
	
}
