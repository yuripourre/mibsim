package concept.nutrient;

import concept.Concept;
import br.com.etyllica.util.SVGColor;


public class WaterFountain extends Concept{

	public WaterFountain(int x, int y) {
		super(x, y);
		color = SVGColor.DEEP_SKY_BLUE;
		nutrients.put(Nutrient.WATER, 100);
	}
	
}
