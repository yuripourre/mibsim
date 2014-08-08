package br.com.mibsim.model.fountain;

public class Need {
	
	private Nutrient nutrient;
	
	private int amountPerDay;
	private int amountReched;
	
	public Need(Nutrient nutrient, int amountPerDay){
		super();
		
		this.nutrient = nutrient;
		this.amountPerDay = amountPerDay;
	}

	public Nutrient getNutrient() {
		return nutrient;
	}

	public void setNutrient(Nutrient nutrient) {
		this.nutrient = nutrient;
	}

	public int getAmountPerDay() {
		return amountPerDay;
	}

	public void setAmountPerDay(int amountPerDay) {
		this.amountPerDay = amountPerDay;
	}

	public int getAmountReched() {
		return amountReched;
	}

	public void setAmountReched(int amountReched) {
		this.amountReched = amountReched;
	}
		

}
