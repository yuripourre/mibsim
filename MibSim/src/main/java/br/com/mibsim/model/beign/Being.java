package br.com.mibsim.model.beign;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.model.fountain.Need;
import br.com.mibsim.model.fountain.Nutrient;
import br.com.mibsim.model.map.GeoMap;

public abstract class Being extends Fountain {

	protected Color bloodColor = Color.RED;
		
	private float metabolism = 1f;
	
	private float fullEnergy = 10000f;
	private float energy = 10000f;

	private List<Need> needs;

	protected int interactionRadius = 55;

	private GeoMap geomap;
	
	protected int walkSpeed = 3;
	
	protected int drainPower = 1;
	
	private BeingListener listener;

	public Being(int x, int y) {
		super(x, y);

		geomap = new GeoMap();

		needs = new ArrayList<Need>();		
		
	}

	protected void addNeed(Need need) {
		needs.add(need);
	}

	public void react() {

		for(Need need: needs) {

			if(need.getAmountReched()<need.getAmountPerDay()) {

				Fountain target = geomap.search(need.getNutrient());

				if(target!=null) {
					
					walkTo(target.getX(), target.getY());
					wasteEnergy(Reaction.WALK);
					
					notifyListener(Reaction.WALK);
					
				} else {
					wasteEnergy(Reaction.BREATHE);
				}
				
			}

		}

	}
	
	private void wasteEnergy(Reaction reaction) {
				
		int wastedFactor;
		
		switch (reaction) {
		default:
		case BREATHE:
			wastedFactor = 1;
			break;

		case WALK:
			wastedFactor = 5;
			break;
		}
		
		float wastedEnergy = metabolism*wastedFactor;
		
		energy -= wastedEnergy;
	}

	private void walkTo(int x, int y) {

		if(this.y<y) {
			this.y+=walkSpeed;
			
			if(listener!=null)
				listener.goDown();
		}
		else if(this.y>y) {
			this.y-=walkSpeed;
			
			if(listener!=null)
				listener.goUp();			
		}

		if(this.x<x) {
			this.x+=walkSpeed;
			
			if(listener!=null)
				listener.goLeft();
		}
		else if(this.x>x) {
			this.x-=walkSpeed;
			
			if(listener!=null)
				listener.goRight();
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

	public boolean haveNeed(Nutrient nutrient) {

		for(Need need: needs) {

			if(need.getNutrient()==nutrient) {
				return true;
			}

		}

		return false;
	}

	public void consume(Fountain fountain) {

		for(Need need: needs) {
			if(fountain.have(need.getNutrient())) {
				fountain.drain(drainPower);
			}
		}
		
	}

	public float getFullEnergy() {
		return fullEnergy;
	}

	public float getEnergy() {
		return energy;
	}

	public int getInteractionRadius() {
		return interactionRadius;
	}	
	
	public void notifyListener(Reaction reaction) {
		if(listener == null) {
			return;
		}
		
		switch (reaction) {
		case WALK:
			listener.onWalk();
			break;

		default:
			break;
		}
		
	}

	public BeingListener getListener() {
		return listener;
	}

	public void setListener(BeingListener listener) {
		this.listener = listener;
	}

	public Color getBloodColor() {
		return bloodColor;
	}

	public void setBloodColor(Color bloodColor) {
		this.bloodColor = bloodColor;
	}	

}
