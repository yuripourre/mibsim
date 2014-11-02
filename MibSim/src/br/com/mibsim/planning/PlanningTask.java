package br.com.mibsim.planning;

import br.com.etyllica.linear.PointInt2D;

public class PlanningTask {

	private PointInt2D target;
	
	private PlanningAction action;
	
	public PlanningTask(PlanningAction action, PointInt2D target) {
		super();
		this.action = action;
		this.target = target;
	}

	public PlanningAction getAction() {
		return action;
	}

	public PointInt2D getTarget() {
		return target;
	}
	
}
