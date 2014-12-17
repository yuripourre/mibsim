package br.com.mibsim.specie;

import br.com.etyllica.layer.ImageLayer;
import br.com.mibsim.building.basement.Basement;
import br.com.mibsim.model.fountain.Nutrient;


public class Lurker extends Speciemen {

	public Lurker(int x, int y, Basement basement) {
		super(x, y, 66, 64, "blue_lurker.png", basement);
		
		layer.setFrames(7);
		
		currentSpeed = 6;
		health = 8000;
		currentHealth = health;
		hungryThreshold = 3600;
		metabolism = 5;
		
		deadLayer = new ImageLayer("blue_lurker_dead.png");
		
		nutrient = Nutrient.ADAMANTITE;
	}

}
