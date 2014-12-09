package br.com.mibsim.editor;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.ImageLayer;

public class WraparoundGrid implements Drawable {

	private int offsetX = 0;

	private int offsetY = 0;

	private ImageLayer tile;

	private int lines = 0;
	private int columns = 0;
	
	public WraparoundGrid(int w, int h, ImageLayer tile) {
		super();
		
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
		for(int j = 0; j < lines; j++) {
			for(int i = 0; i < columns; i++) {
				tile.simpleDraw(g, offsetX+i*tile.utilWidth(), offsetY+j*tile.utilHeight());
			}
		}
	}
}
