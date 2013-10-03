package concept.nutrient;

import br.com.etyllica.util.SVGColor;
import concept.Concept;


public class FoodFountain extends Concept{

	public FoodFountain(int x, int y) {
		super(x, y);
		color = SVGColor.CORAL;
		nutrients.put(Nutrient.FOOD, 100);
	}
	
}
