package concept.being.creature;

import br.com.etyllica.util.SVGColor;
import concept.being.Being;
import concept.nutrient.Need;
import concept.nutrient.Nutrient;

public class YellowCreature extends Being {

	public YellowCreature(int x, int y) {
		super(x, y);

		colorFill = SVGColor.YELLOW;
		
		addNeed(new Need(Nutrient.WATER, 50));
	}
	
}
