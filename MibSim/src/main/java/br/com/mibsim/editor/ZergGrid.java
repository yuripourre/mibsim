package br.com.mibsim.editor;

import br.com.etyllica.layer.ImageLayer;

public class ZergGrid extends WraparoundGrid {

	public ZergGrid(int w, int h) {
		super(w, h);
		
		ImageLayer tile = new ImageLayer(0, 0, 32, 32,"tiles/tileset.png");
		tile.setImageCoordinates(0, 32);
		
		setupTile(tile);
		
		drawGrid = true;
	}

}
