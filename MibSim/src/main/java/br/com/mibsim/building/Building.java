package br.com.mibsim.building;

import java.awt.Color;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.layer.ImageLayer;
import br.com.etyllica.linear.PointInt2D;

public class Building extends GeometricLayer implements Drawable {
	
	private PointInt2D center;
	
	private ImageLayer layer;
	
	private static final int TILE_SIZE = 32;
	
	public Building(int x, int y, String path) {
		super(x, y, TILE_SIZE, TILE_SIZE);
		
		center = new PointInt2D(x+TILE_SIZE/2, y+TILE_SIZE/2);
		
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

	public PointInt2D getCenter() {
		return center;
	}

	public void setCenter(PointInt2D center) {
		this.center = center;
	}
		
}
