package br.com.mibsim.specie;

import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.mibsim.planning.PlanningTask;
import br.com.tide.action.player.ActionPlayer;

public class Specie extends ActionPlayer implements Drawable {

	protected List<PlanningTask> tasks = new ArrayList<PlanningTask>();
	
	protected AnimatedLayer layer;
		
	public Specie(int x, int y, int tileW, int tileH, String path) {
		super(x, y);
		
		startAngle = 0;
		
		layer = new AnimatedLayer(x, y, tileW, tileH, path);
		layer.setAnimateHorizontally(false);
		layer.setSpeed(100);
		layer.setFrames(7);
	}
	
	@Override
	public void update(long now) {
		super.update(now);

		if(isWalking()) {
			layer.animate(now);
			layer.setCoordinates(x, y);
		}

		if(isTurning()) {
			layer.setAngle(angle);
		}
		
	}

	@Override
	public void draw(Graphic g) {
		layer.draw(g);
	}
	
}
