package br.com.mibsim.specie;

import br.com.mibsim.building.basement.Basement;


public class RedHydralisk extends Specie {

	public RedHydralisk(int x, int y, Basement basement) {
		super(x, y, 42, 405/7, "red_hydralisk.png", basement);
		layer.setFrames(7);
	}

}
