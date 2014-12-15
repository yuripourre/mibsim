package br.com.mibsim.ui;


public class LurkerForm extends SpinnerForm {

	public LurkerForm(int x, int y) {
		super("Lurker", x, y);
		speedSpinner.setValue(6);
		metabolismSpinner.setValue(5);
		hungerSpinner.setValue(3600);
		capacitySpinner.setValue(8000);
	}	
	
}
