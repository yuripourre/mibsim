package br.com.mibsim.editor;

import java.awt.Color;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.ImageLayer;

public class WraparoundGrid implements Drawable {

	private int offsetX = 0;

	private int offsetY = 0;

	private ImageLayer tile;

	private int lines = 0;
	private int columns = 0;
	
	private int w = 0;
	private int h = 0;
	
	protected boolean drawGrid = false; 
	
	public WraparoundGrid(int w, int h, ImageLayer tile) {
		super();
		
		this.w = w;
		this.h = h;
		
		setupTile(tile);
	}
	
	public WraparoundGrid(int w, int h) {
		super();
		
		this.w = w;
		this.h = h;		
	}
	
	protected void setupTile(ImageLayer tile) {
		
		lines = h/tile.getH()+2;
		columns = w/tile.getW()+2;
		
		this.tile = tile;
	}	

	public void translate(int offsetX, int offsetY) {
		this.offsetX += offsetX;
		this.offsetY += offsetY;
		
		if(this.offsetX < -tile.utilWidth()) {
			this.offsetX = this.offsetX+tile.utilWidth();
		} else if(this.offsetX > 0) {
			this.offsetX = this.offsetX-tile.utilWidth();
		}
		
		if(this.offsetY < -tile.utilHeight()) {
			this.offsetY = this.offsetY+tile.utilHeight();
		} else if(this.offsetY > 0) {
			this.offsetY = this.offsetY-tile.utilHeight();
		}		
	}

	@Override
	public void draw(Graphic g) {
		
		g.setColor(Color.BLACK);
		
		for(int j = 0; j < lines; j++) {
			for(int i = 0; i < columns; i++) {
				
				int x = offsetX+i*tile.utilWidth();
				int y = offsetY+j*tile.utilHeight();
				
				tile.simpleDraw(g, x, y);
				
				if(drawGrid) {
					g.drawLine(x, y, x+tile.utilWidth(), y);
					g.drawLine(x, y, x, y+tile.utilHeight());
				}
			}
		}
		
	}
}
