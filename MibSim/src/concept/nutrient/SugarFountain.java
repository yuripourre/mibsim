package concept.nutrient;

import br.com.etyllica.util.SVGColor;
import concept.Concept;


public class SugarFountain extends Concept{
	
	public SugarFountain(int x, int y) {
		super(x, y, "sugar.png");
		colorFill = SVGColor.WHITE;
		nutrients.put(Nutrient.SUGAR, 100);
		
		quantity = 5;
	}
	
}
