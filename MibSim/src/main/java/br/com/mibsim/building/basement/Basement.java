package br.com.mibsim.building.basement;

import br.com.etyllica.linear.PointInt2D;
import br.com.etyllica.util.kdtree.KDTree;
import br.com.mibsim.building.Building;
import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.planning.PlanningAction;
import br.com.mibsim.planning.PlanningTask;

public class Basement extends Building {

	private int perimeter = 1;
	
	private int currentIndex = 0;
	
	private KDTree<Fountain> fountains = new KDTree<Fountain>(2);
	
	public Basement(int x, int y) {
		super(x, y);
	}
	
	public Basement(int x, int y, String path) {
		super(x, y, path);
	}

	public KDTree<Fountain> getFountains() {
		return fountains;
	}

	public PlanningTask askForDesignation() {
		
		PointInt2D target = nextTarget(currentIndex);

		currentIndex++;
		currentIndex %= perimeter * 8;
		
		return new PlanningTask(PlanningAction.EXPLORE, target);
	}
	
	public PointInt2D nextTarget(int index) {
		
		final int LINE_WIDTH = perimeter*2+1;
		
		final int SECTOR_WIDTH = 64;
		final int SECTOR_HEIGHT = 64;
		
		int x = getCenter().getX() - SECTOR_WIDTH;
		int y = getCenter().getY() - SECTOR_HEIGHT;
		
		final int C2 = LINE_WIDTH*2-1;//4
		final int C3 = LINE_WIDTH*3-perimeter*2;//6
				
		if(index < LINE_WIDTH) {
			x += - SECTOR_WIDTH * perimeter + SECTOR_WIDTH * index;
			y += - SECTOR_HEIGHT * perimeter; 
		} else if(index < C2) {
			x += SECTOR_WIDTH * perimeter;
			y += - SECTOR_HEIGHT * perimeter + SECTOR_HEIGHT * (index-LINE_WIDTH+1);
		} else if(index < C3) {
			x += SECTOR_WIDTH * perimeter - SECTOR_WIDTH * (index-C3+3);
			y += SECTOR_HEIGHT * perimeter; 
		} else {
			x += - SECTOR_WIDTH * perimeter;
			y += - SECTOR_HEIGHT * perimeter + (perimeter*8-index) * SECTOR_HEIGHT;
		}
		
		PointInt2D target = new PointInt2D(x, y);
				
		return target;
	}
	
	public PlanningTask reportToBasement() {
		
		return new PlanningTask(PlanningAction.REPORT, getCenter());
	}

}
