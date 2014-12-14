package br.com.mibsim.ui;


public class HungerThresholdSpinner extends MibSimSpinner {

	public HungerThresholdSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		value = 3000;
		step = 100;
		maxValue = 100000;
		minValue = 0;
	}
	
}
