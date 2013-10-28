package concept.nutrient;

import concept.Concept;


public class WaterFountain extends Concept{
	
	public WaterFountain(int x, int y) {
		super(x, y, "water.png");
		nutrients.put(Nutrient.WATER, 100);
		
		quantity = 10;
	}
	
}
