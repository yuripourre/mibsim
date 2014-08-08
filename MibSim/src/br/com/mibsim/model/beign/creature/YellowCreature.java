package br.com.mibsim.model.beign.creature;

import br.com.etyllica.core.graphics.SVGColor;
import br.com.mibsim.model.beign.Being;
import br.com.mibsim.model.fountain.Need;
import br.com.mibsim.model.fountain.Nutrient;

public class YellowCreature extends Being {

	public YellowCreature(int x, int y) {
		super(x, y);		
		
		addNeed(new Need(Nutrient.WATER, 50));

		bloodColor = SVGColor.YELLOW;
		
		imagePath = "greenbug.png";
		
	}
	
	
	
}
