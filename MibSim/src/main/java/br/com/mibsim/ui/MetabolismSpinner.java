package br.com.mibsim.ui;


public class MetabolismSpinner extends MibSimSpinner {

	public MetabolismSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		value = 1;
		step = 1;
		maxValue = 10000;
		minValue = 1;
	}
	
}
