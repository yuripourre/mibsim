package concept.being;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import map.GeoMap;
import br.com.etyllica.core.video.Grafico;
import concept.Concept;
import concept.nutrient.Need;
import concept.nutrient.Nutrient;

public abstract class Being extends Concept{
	
	private double metabolism = 1f;
	
	private List<Need> needs;
	
	protected int interactionRadius = 42;
	
	private GeoMap geomap;

	public Being(int x, int y) {
		super(x, y);
		
		geomap = new GeoMap();
		
		needs = new ArrayList<Need>();
				
	}
	
	protected void addNeed(Need need){
		needs.add(need);	
	}
	
	@Override
	public void draw(Grafico g){
		
		g.setColor(color);
		g.fillOval(x*TILE_SIZE, y*TILE_SIZE, w, h);
		
		g.setColor(Color.BLACK);
		g.drawOval(x*TILE_SIZE, y*TILE_SIZE, w, h);
		
	}
	
	public void drawInteractionRadius(Grafico g){
		g.setColor(Color.BLACK);
		g.setAlpha(70);
		g.fillCircle(x*TILE_SIZE+(TILE_SIZE/2), y*TILE_SIZE+(TILE_SIZE/2), interactionRadius);
		g.setAlpha(100);
	}
	
	public void react(){
		
		for(Need need: needs){
			
			if(need.getAmountReched()<need.getAmountPerDay()){
				
				Concept concept = geomap.search(need.getNutrient());
				
				if(concept!=null){
					walkTo(concept.getX(), concept.getY());
				}
				
			}
			
		}
		
	}	
		
	private void walkTo(int x, int y){
		
		if(this.x<x){
			this.x++;
		}
		else if(this.x>x){
			this.x--;
		}
		
		if(this.y<y){
			this.y++;
		}
		else if(this.y>y){
			this.y--;
		}
		
	}
	
	public GeoMap getGeomap() {
		return geomap;
	}

	public void setGeomap(GeoMap geomap) {
		this.geomap = geomap;
	}

	public List<Need> getNeeds() {
		return needs;
	}

	public void setNeeds(List<Need> needs) {
		this.needs = needs;
	}
	
	public boolean haveNeed(Nutrient nutrient){
		
		for(Need need: needs){
			
			if(need.getNutrient()==nutrient){
				return true;
			}
			
		}
		
		return false;
	}
	
}
