package concept;

import java.util.HashMap;
import java.util.Map;

import br.com.etyllica.layer.Layer;
import concept.nutrient.Nutrient;

public class Fountain extends Layer{

	protected Map<Nutrient, Integer> nutrients = new HashMap<Nutrient, Integer>();
	
	protected final static int TILE_SIZE = 16;
	
	public Fountain(int x, int y){
		super(x,y,TILE_SIZE,TILE_SIZE);		
	}
	
	public boolean have(Nutrient nutrient){
		return nutrients.containsKey(nutrient);
	}
	
}
