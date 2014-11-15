package br.com.mibsim.model.fountain;


public class AdamantiteFountain extends Fountain {
	
	public AdamantiteFountain(int x, int y) {
		super(x, y);
		
		imagePath = "adamantite.png";
		
		putNutrient(Nutrient.ADAMANTITE, 100);		
	}
	
}
