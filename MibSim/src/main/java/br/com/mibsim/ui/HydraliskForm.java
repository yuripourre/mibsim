package br.com.mibsim.ui;


public class HydraliskForm extends SpinnerForm {

	public HydraliskForm(int x, int y) {
		super("Hydralisk", x, y);
		speedSpinner.setValue(8);
		metabolismSpinner.setValue(2);
		hungerSpinner.setValue(3300);
		capacitySpinner.setValue(5000);
	}	
	
}
