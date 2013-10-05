package concept;

import java.util.HashMap;
import java.util.Map;

import br.com.etyllica.layer.AnimatedLayer;
import concept.nutrient.Nutrient;

public class Fountain extends AnimatedLayer{

	protected Map<Nutrient, Integer> nutrients = new HashMap<Nutrient, Integer>();
	
	public final static int TILE_SIZE = 48;
	
	public Fountain(int x, int y){
		super(x,y,TILE_SIZE,TILE_SIZE);
	}
	
	public boolean have(Nutrient nutrient){
		return nutrients.containsKey(nutrient);
	}
	
}
