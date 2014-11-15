package br.com.mibsim.model.beign.creature;

import br.com.etyllica.core.graphics.SVGColor;
import br.com.mibsim.model.beign.Being;
import br.com.mibsim.model.fountain.Need;
import br.com.mibsim.model.fountain.Nutrient;

public class BlueCreature extends Being {

	public BlueCreature(int x, int y) {
		super(x, y);
		
		this.interactionRadius = 28;
		this.walkSpeed = 8;
		
		this.addNeed(new Need(Nutrient.WATER, 500));
		
		bloodColor = SVGColor.DARK_BLUE;
		
		imagePath = "purplebug.png";
	}

	
	
}
