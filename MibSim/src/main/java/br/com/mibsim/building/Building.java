package br.com.mibsim.building;

import java.awt.Color;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.layer.ImageLayer;

public class Building extends GeometricLayer implements Drawable {
	
	private ImageLayer layer;
	
	public Building(int x, int y, String path) {
		super(x, y, 32, 32);
		
		layer = new ImageLayer(path);
		layer.centralize(this);
	}

	@Override
	public void draw(Graphic g) {
		g.setAlpha(50);
		layer.draw(g);
		
		g.setColor(Color.RED);
		g.fillRect(this);
		g.resetOpacity();
	}
	
	
}
