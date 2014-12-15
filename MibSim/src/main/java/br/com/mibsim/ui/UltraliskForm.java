package br.com.mibsim.ui;


public class UltraliskForm extends SpinnerForm {

	public UltraliskForm(int x, int y) {
		super("Ultralisk", x, y);
		speedSpinner.setValue(5);
		metabolismSpinner.setValue(3);
		hungerSpinner.setValue(3300);
		capacitySpinner.setValue(10000);
	}	
	
}
