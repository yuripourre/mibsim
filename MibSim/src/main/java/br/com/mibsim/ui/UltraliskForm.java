package br.com.mibsim.ui;

import br.com.mibsim.ui.avatar.UltraliskAvatar;


public class UltraliskForm extends SpinnerForm {

	public UltraliskForm(int x, int y) {
		super("Ultralisk", x, y);
		
		avatar = new UltraliskAvatar(x, y);
		
		speedSpinner.setValue(5);
		metabolismSpinner.setValue(3);
		hungerSpinner.setValue(3300);
		capacitySpinner.setValue(10000);
	}	
	
}
