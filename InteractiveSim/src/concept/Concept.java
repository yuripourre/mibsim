package concept;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import br.com.etyllica.core.video.Grafico;
import br.com.etyllica.layer.Layer;
import concept.nutrient.Nutrient;

public class Concept extends Layer{

	protected Color color = Color.GREEN;
	protected final static int TILE_SIZE = 16;
	
	protected Map<Nutrient, Integer> nutrients;
	
	public Concept(int x, int y){
		super(x,y,TILE_SIZE,TILE_SIZE);
		nutrients = new HashMap<Nutrient, Integer>();
	}
	
	public boolean have(Nutrient nutrient){
		return nutrients.containsKey(nutrient);
	}
	
	public void draw(Grafico g){
		g.setColor(color);
		g.fillRect(x*TILE_SIZE, y*TILE_SIZE, w, h);
		
		g.setColor(Color.BLACK);
		g.drawRect(x*TILE_SIZE, y*TILE_SIZE, w, h);
	}	
	
}
