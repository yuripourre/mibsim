package concept.nutrient;

import concept.Concept;
import br.com.etyllica.util.SVGColor;


public class FoodFountain extends Concept{

	public FoodFountain(int x, int y) {
		super(x, y);
		color = SVGColor.CORAL;
		nutrients.put(Nutrient.FOOD, 100);
	}
	
}
