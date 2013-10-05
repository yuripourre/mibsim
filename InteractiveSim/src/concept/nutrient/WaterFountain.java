package concept.nutrient;

import br.com.etyllica.util.SVGColor;
import concept.Concept;


public class WaterFountain extends Concept{

	public WaterFountain(int x, int y) {
		super(x, y);
		colorFill = SVGColor.DEEP_SKY_BLUE;
		nutrients.put(Nutrient.WATER, 100);
	}
	
}
