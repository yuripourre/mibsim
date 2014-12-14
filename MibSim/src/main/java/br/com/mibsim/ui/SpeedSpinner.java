package br.com.mibsim.ui;


public class SpeedSpinner extends MibSimSpinner {

	public SpeedSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		value = 1;
		step = 1;
		maxValue = 90;
		minValue = 1;
	}

}
