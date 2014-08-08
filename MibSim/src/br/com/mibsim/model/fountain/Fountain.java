package br.com.mibsim.model.fountain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.com.mibsim.model.Concept;

public abstract class Fountain extends Concept {
	
	protected Map<Nutrient, Integer> nutrients = new HashMap<Nutrient, Integer>();
	
	protected int x;
	
	protected int y;
	
	protected String imagePath;
	
	public Fountain(int x, int y) {
		super();
		
		this.x = x;
		this.y = y;
	}
	
	public void putNutrient(Nutrient nutrient, int quantity) {
		nutrients.put(nutrient, quantity);
	}
	
	public boolean have(Nutrient nutrient) {
		return nutrients.containsKey(nutrient);
	}

	protected boolean drained = false;
	
	public int drain(int quantity) {
		
		drained = true;
		
		int quantityLeft = 0;
		
		for(Entry<Nutrient, Integer> nutrient: nutrients.entrySet()){
			int amount = nutrient.getValue();
			
			quantityLeft = amount-quantity;
			
			nutrients.put(nutrient.getKey(), quantityLeft);
		}
		
		return quantityLeft;		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getImagePath() {
		return imagePath;
	}
		
}
