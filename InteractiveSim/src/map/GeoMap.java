package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.etyllica.core.DrawableComponent;
import br.com.etyllica.core.video.Graphic;
import concept.Concept;
import concept.nutrient.Nutrient;

public class GeoMap implements DrawableComponent{
		
	private Map<Integer, Map<Integer,List<Concept>>> map;
	
	public GeoMap() {
		super();
		
		map = new HashMap<Integer, Map<Integer, List<Concept>>>();
	}
	
	public void add(Concept concept){
		
		avoidNull(concept.getX(), concept.getY());
		map.get(concept.getX()).get(concept.getY()).add(concept);
		
	}
	
	public List<Concept> get(int x, int y){
		
		avoidNull(x, y);
		
		return map.get(x).get(y);
		
	}
	
	private void avoidNull(int x, int y){
		if(map.get(x)==null){
			map.put(x, new HashMap<Integer, List<Concept>>());
		}
		
		if(map.get(x).get(y)==null){
			map.get(x).put(y, new ArrayList<Concept>());
		}
	}
	
	public void draw(Graphic g){
		
		for(Map<Integer,List<Concept>> xMap: map.values()){
			
			for(List<Concept> concepts: xMap.values()){
				
				for(Concept concept: concepts){
					concept.draw(g);
				}
				
			}
			
		}
		
	}
	
	public Concept search(Nutrient nutrient){
		
		for(Map<Integer,List<Concept>> xMap: map.values()){
			
			for(List<Concept> concepts: xMap.values()){
				
				for(Concept concept: concepts){
					if(concept.have(nutrient)){
						return concept;
					}
				}
				
			}
			
		}
		
		return null;
		
	}

	public void addAll(List<Concept> concepts) {
		
		for(Concept concept: concepts){
			this.add(concept);
		}
		
	}
	
}
