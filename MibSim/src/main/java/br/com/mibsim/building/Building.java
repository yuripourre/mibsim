package br.com.mibsim.building;

import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.layer.ImageLayer;
import br.com.etyllica.linear.PointInt2D;

public class Building extends GeometricLayer {
	
	private PointInt2D center;
	
	private ImageLayer layer;
	
	private static final int TILE_SIZE = 32;
	
	public Building(int x, int y) {
		super(x, y, TILE_SIZE, TILE_SIZE);
		
		center = new PointInt2D(x+TILE_SIZE/2, y+TILE_SIZE/2);
	}
	
	public Building(int x, int y, String path) {
		this(x, y);		
		
		layer = new ImageLayer(path);
		layer.centralize(this);
	}

	public void draw(Graphic g, int x, int y) {
		//g.setAlpha(50);
		layer.draw(g, x, y);
		
		/*g.setColor(Color.RED);
		g.fillRect(this);
		g.resetOpacity();*/
	}

	public PointInt2D getCenter() {
		return center;
	}

	public void setCenter(PointInt2D center) {
		this.center = center;
	}
	
	public double[] getPositionAsArray() {
		
		double[] position = new double[2];
		position[0] = center.getX();
		position[1] = center.getY();
		
		return position;
	}
	
}
