package br.com.mibsim.ui;


public class CapacitySpinner extends MibSimSpinner {

	public CapacitySpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		value = 0;
		step = 100;
		maxValue = 100000;
		minValue = 0;
	}
	
}
