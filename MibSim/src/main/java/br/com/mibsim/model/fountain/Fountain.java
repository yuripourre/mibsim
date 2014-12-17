package br.com.mibsim.model.fountain;

import br.com.mibsim.building.Building;
import br.com.mibsim.specie.Speciemen;

public abstract class Fountain extends Building {
		
	protected static final int INFINITY = Integer.MAX_VALUE; 
			
	protected Nutrient nutrient;
	
	private int currentCapacity = INFINITY;
	
	protected int totalCapacity = INFINITY;
			
	public Fountain(int x, int y, Nutrient nutrient, String path) {
		super(x, y, path);
				
		this.nutrient = nutrient;
	}
		
	public int drain(Speciemen speciemen) {
		
		int quantity = 100;
		
		if(totalCapacity != INFINITY) {
			currentCapacity -= quantity;
		}
				
		return quantity;
	}

	public Nutrient getNutrient() {
		return nutrient;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}	
	
}
