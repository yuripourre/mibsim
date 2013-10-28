package concept.nutrient;

import br.com.etyllica.util.SVGColor;
import concept.Concept;


public class AdamantiteFountain extends Concept{
	
	public AdamantiteFountain(int x, int y) {
		super(x, y, "adamantite.png");
		colorFill = SVGColor.GRAY;
		nutrients.put(Nutrient.ADAMANTITE, 100);
		
		quantity = 5;
	}
	
}
