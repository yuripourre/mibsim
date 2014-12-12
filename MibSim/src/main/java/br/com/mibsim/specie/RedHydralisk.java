package br.com.mibsim.specie;

import br.com.etyllica.layer.ImageLayer;
import br.com.mibsim.building.basement.Basement;


public class RedHydralisk extends Speciemen {

	public RedHydralisk(int x, int y, Basement basement) {
		super(x, y, 42, 405/7, "red_hydralisk.png", basement);
		layer.setFrames(7);
		
		deadLayer = new ImageLayer("red_hydralisk_dead.png");
	}

}
