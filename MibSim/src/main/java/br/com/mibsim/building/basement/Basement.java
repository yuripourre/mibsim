package br.com.mibsim.building.basement;

import br.com.etyllica.util.kdtree.KDTree;
import br.com.mibsim.building.Building;
import br.com.mibsim.model.fountain.Fountain;

public class Basement extends Building {

	private KDTree<Fountain> fountains = new KDTree<Fountain>(2);
	
	public Basement(int x, int y, String path) {
		super(x, y, path);
	}

	public KDTree<Fountain> getFountains() {
		return fountains;
	}

}
