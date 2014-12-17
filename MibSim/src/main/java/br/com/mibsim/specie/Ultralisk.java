package br.com.mibsim.specie;

import br.com.etyllica.layer.ImageLayer;
import br.com.mibsim.building.basement.Basement;


public class Ultralisk extends Speciemen {

	public Ultralisk(int x, int y, Basement basement) {
		super(x, y, 100, 108, "green_ultralisk.png", basement);

		currentSpeed = 5;
		health = 10000;
		currentHealth = health;
		hungryThreshold = 3300;
		metabolism = 3;
		
		deadLayer = new ImageLayer("green_ultralisk_dead.png");
	}

}
