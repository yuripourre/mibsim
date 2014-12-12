package br.com.mibsim.specie;

import br.com.etyllica.layer.ImageLayer;
import br.com.mibsim.building.basement.Basement;


public class BlueLurker extends Speciemen {

	public BlueLurker(int x, int y, Basement basement) {
		super(x, y, 66, 64, "blue_lurker.png", basement);
				
		layer.setFrames(7);
		
		deadLayer = new ImageLayer("blue_lurker_dead.png");
	}

}
