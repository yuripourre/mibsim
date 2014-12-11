package br.com.mibsim.building.basement;

import br.com.etyllica.linear.PointInt2D;
import br.com.etyllica.util.kdtree.KDTree;
import br.com.mibsim.building.Building;
import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.planning.PlanningAction;
import br.com.mibsim.planning.PlanningTask;

public class Basement extends Building {

	private int perimeter = 1;
	
	private KDTree<Fountain> fountains = new KDTree<Fountain>(2);
	
	public Basement(int x, int y, String path) {
		super(x, y, path);
	}

	public KDTree<Fountain> getFountains() {
		return fountains;
	}

	public PlanningTask askForDesignation() {
		
		PointInt2D target = nextTarget();
		
		return new PlanningTask(PlanningAction.EXPLORE, target);
	}
	
	private PointInt2D nextTarget() {
		
		PointInt2D target = new PointInt2D(getCenter().getX()-64, getCenter().getY()-64);
		
		return target;
	}

	public PlanningTask reportToBasement() {
		
		return new PlanningTask(PlanningAction.REPORT, getCenter());
	}

}
