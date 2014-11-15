package br.com.mibsim.specie;

import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.linear.Point2D;
import br.com.etyllica.linear.PointInt2D;
import br.com.mibsim.building.basement.Basement;
import br.com.mibsim.planning.PlanningAction;
import br.com.mibsim.planning.PlanningTask;
import br.com.tide.action.player.ActionPlayer;

public class Specie extends ActionPlayer implements Drawable {
		
	protected AnimatedLayer layer;
	
	protected Basement basement;
		
	private PlanningTask lastTask;
	
	protected List<PlanningTask> tasks = new ArrayList<PlanningTask>();
			
	public Specie(int x, int y, int tileW, int tileH, String path, Basement basement) {
		super(x, y);
		
		startAngle = 0;
		
		layer = new AnimatedLayer(x, y, tileW, tileH, path);
		layer.setAnimateHorizontally(false);
		layer.setSpeed(100);
		layer.setFrames(7);
		
		this.basement = basement;
		
		tasks.add(new PlanningTask(PlanningAction.REPORT, basement.getCenter()));
		
	}
	
	@Override
	public void update(long now) {
		super.update(now);
		
		act();
		
		if(isWalking()) {
			layer.animate(now);
			layer.setCoordinates(x, y);
		}

		if(isTurning()) {
			layer.setAngle(angle);
		}
			
	}
	
	private void act() {
				
		PlanningTask currentTask = currentTask();
		
		PointInt2D target = currentTask.getTarget();
		
		if(currentTask != lastTask) {
			lastTask = currentTask;
			turnToTarget(target);
		}
		
		if(!reachTarget(target)) {
			walkForward();
		} else {
			stopWalk();
		}
		
	}
	
	private void turnToTarget(PointInt2D target) {
		
		int cx = layer.getX()+layer.utilWidth()/2;
		int cy = layer.getY()+layer.utilHeight()/2;
		
		double angle = Point2D.angle(cx, cy, target.getX(), target.getY());
		
		this.setStartAngle(angle+90);
		
		//Compensate sprite rotation
		layer.setAngle(angle+90);
		
	}
	
	private boolean reachTarget(PointInt2D target) {
		
		int cx = layer.getX()+layer.utilWidth()/2;
		int cy = layer.getY()+layer.utilHeight()/2;
		
		double distance = Point2D.distance(cx, cy, target.getX(), target.getY());
				
		return distance < 10;		
	}
	
	private PlanningTask currentTask() {
		return tasks.get(tasks.size()-1);
	}	
		
	public Basement getBasement() {
		return basement;
	}

	public void setBasement(Basement basement) {
		this.basement = basement;
	}

	@Override
	public void draw(Graphic g) {
		layer.draw(g);		
	}
	
}
