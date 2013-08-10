package concept.being.creature;

import concept.being.Being;
import concept.nutrient.Need;
import concept.nutrient.Nutrient;
import br.com.etyllica.util.SVGColor;

public class YellowCreature extends Being {

	public YellowCreature(int x, int y) {
		super(x, y);

		color = SVGColor.YELLOW;
		
		//addNeed(new Need(Nutrient.WATER, 50));
	}

	
	
}
