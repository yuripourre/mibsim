package br.com.mibsim.model.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.model.fountain.Nutrient;

public class GeoMap {
		
	private Map<Integer, Map<Integer, List<Fountain>>> map;
	
	public GeoMap() {
		super();
		
		map = new HashMap<Integer, Map<Integer, List<Fountain>>>();
	}
	
	public void add(Fountain concept) {
		
		avoidNull(concept.getX(), concept.getY());
		
		map.get(concept.getX()).get(concept.getY()).add(concept);
		
	}
	
	public List<Fountain> get(int x, int y){
		
		avoidNull(x, y);
		
		return map.get(x).get(y);
		
	}
	
	private void avoidNull(int x, int y){
		if(map.get(x)==null){
			map.put(x, new HashMap<Integer, List<Fountain>>());
		}
		
		if(map.get(x).get(y)==null){
			map.get(x).put(y, new ArrayList<Fountain>());
		}
	}
		
	public Fountain search(Nutrient nutrient){
		
		for(Map<Integer,List<Fountain>> xMap: map.values()){
			
			for(List<Fountain> concepts: xMap.values()){
				
				for(Fountain concept: concepts){
					if(concept.have(nutrient)){
						return concept;
					}
				}
				
			}
			
		}
		
		return null;
		
	}

	public void addAll(List<Fountain> concepts) {
		
		for(Fountain concept: concepts){
			this.add(concept);
		}		
	}

	public Map<Integer, Map<Integer, List<Fountain>>> getMap() {
		return map;
	}	
	
}
