package br.com.mibsim.ui.spinner;


public class HungerThresholdSpinner extends MibSimSpinner {

	public HungerThresholdSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		value = 1200;
		step = 100;
		maxValue = 100000;
		minValue = 0;
		
		reload();
	}
	
}
