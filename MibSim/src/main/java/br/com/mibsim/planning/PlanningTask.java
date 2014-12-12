package br.com.mibsim.planning;

import br.com.etyllica.linear.PointInt2D;

public class PlanningTask {

	public static final int EMPTY_REFERENCE = -1;
	
	private PointInt2D target;
	
	private PlanningAction action;
	
	private int reference = EMPTY_REFERENCE;
	
	private boolean completed = false;
	
	public PlanningTask(PlanningAction action, PointInt2D target) {
		super();
		this.action = action;
		this.target = target;
	}
	
	public PlanningTask(PlanningAction action, PointInt2D target, int reference) {
		super();
		this.action = action;
		this.target = target;
		this.reference = reference;
	}

	public PlanningAction getAction() {
		return action;
	}

	public PointInt2D getTarget() {
		return target;
	}
	
	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
		
}
