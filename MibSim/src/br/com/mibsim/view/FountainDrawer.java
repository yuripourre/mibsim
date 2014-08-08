package br.com.mibsim.view;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.ImageLayer;
import br.com.mibsim.model.fountain.Fountain;

public class FountainDrawer implements Drawable {
	
	protected Fountain fountain;
	
	private ImageLayer layer;
	
	public FountainDrawer(Fountain fountain) {
		super();
		
		this.fountain = fountain;
		
		layer = new ImageLayer(fountain.getX(), fountain.getY(), fountain.getImagePath());		
	}
	
	public int getX() {
		return layer.getX();
	}
	
	public int getY() {
		return layer.getY();
	}

	public void draw(Graphic g) {
		layer.draw(g);
	}	

	public Fountain getFountain() {
		return fountain;
	}

	public void setFountain(Fountain fountain) {
		this.fountain = fountain;
	}

	public ImageLayer getLayer() {
		return layer;
	}

}
