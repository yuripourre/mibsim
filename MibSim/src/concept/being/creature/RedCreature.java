package concept.being.creature;

import concept.being.Being;
import concept.nutrient.Need;
import concept.nutrient.Nutrient;
import br.com.etyllica.util.SVGColor;

public class RedCreature extends Being {

	public RedCreature(int x, int y) {
		super(x, y);

		colorFill = SVGColor.CRIMSON;

		addNeed(new Need(Nutrient.FOOD, 200));
		
		this.path = "redbug.png";
		
	}
	
}
