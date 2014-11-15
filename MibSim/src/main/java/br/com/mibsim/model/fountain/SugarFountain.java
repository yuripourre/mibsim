package br.com.mibsim.model.fountain;



public class SugarFountain extends Fountain {
	
	public SugarFountain(int x, int y) {
		super(x, y);
		
		imagePath = "sugar.png";
		
		putNutrient(Nutrient.SUGAR, 100);				
	}
	
}
