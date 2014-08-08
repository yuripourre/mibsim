package br.com.mibsim.model.beign.creature;

import br.com.etyllica.core.graphics.SVGColor;
import br.com.mibsim.model.beign.Being;
import br.com.mibsim.model.fountain.Need;
import br.com.mibsim.model.fountain.Nutrient;

public class RedCreature extends Being {

	public RedCreature(int x, int y) {
		super(x, y);

		addNeed(new Need(Nutrient.SUGAR, 200));
		
		bloodColor = SVGColor.CRIMSON;
		
		imagePath = "redbug.png";
		
	}
	
}
