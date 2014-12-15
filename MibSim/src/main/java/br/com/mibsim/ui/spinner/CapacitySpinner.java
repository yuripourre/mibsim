package br.com.mibsim.ui.spinner;


public class CapacitySpinner extends MibSimSpinner {

	public CapacitySpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		value = 3000;
		step = 100;
		maxValue = 100000;
		minValue = 0;
		
		reload();
	}
	
}
