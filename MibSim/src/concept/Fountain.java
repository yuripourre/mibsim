package concept;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.com.etyllica.layer.AnimatedLayer;
import concept.nutrient.Nutrient;

public abstract class Fountain extends AnimatedLayer{

	protected Map<Nutrient, Integer> nutrients = new HashMap<Nutrient, Integer>();
	
	public final static int TILE_SIZE = 48;
	
	protected int quantity = 5;
	
	public Fountain(int x, int y){
		super(x,y,TILE_SIZE,TILE_SIZE);
	}
	
	public boolean have(Nutrient nutrient){
		return nutrients.containsKey(nutrient);
	}

	protected boolean drained = false;
	
	public int drain() {
		
		drained = true;
		
		for(Entry<Nutrient, Integer> nutrient: nutrients.entrySet()){
			int amount = nutrient.getValue();
			nutrients.put(nutrient.getKey(), amount-quantity);	
		}
		
		return quantity;
	}
	
}
