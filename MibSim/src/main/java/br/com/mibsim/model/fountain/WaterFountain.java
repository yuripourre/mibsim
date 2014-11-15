package br.com.mibsim.model.fountain;




public class WaterFountain extends Fountain {
	
	public WaterFountain(int x, int y) {
		super(x, y);
		
		imagePath = "water.png";
		
		putNutrient(Nutrient.WATER, 100);	
	}
	
}
