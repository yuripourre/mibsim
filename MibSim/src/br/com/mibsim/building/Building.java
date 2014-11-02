package br.com.mibsim.building;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.ImageLayer;

public class Building implements Drawable {
	
	private ImageLayer layer;
	
	public Building(int x, int y, String path) {
		super();
		
		layer = new ImageLayer(x, y, path);
	}

	@Override
	public void draw(Graphic g) {
		layer.draw(g);
	}
	
	
}
