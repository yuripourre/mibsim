package br.com.mibsim.specie;

import br.com.etyllica.layer.ImageLayer;
import br.com.mibsim.building.basement.Basement;


public class Hydralisk extends Speciemen {

	public Hydralisk(int x, int y, Basement basement) {
		super(x, y, 42, 405/7, "red_hydralisk.png", basement);
		layer.setFrames(7);
		
		currentSpeed = 8;
		health = 5000;
		currentHealth = health;
		hungryThreshold = 3000;
		metabolism = 2;
		
		deadLayer = new ImageLayer("red_hydralisk_dead.png");
	}

}
