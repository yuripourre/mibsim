package br.com.mibsim.ui;

import br.com.mibsim.ui.avatar.HydraliskAvatar;


public class HydraliskForm extends SpinnerForm {

	public HydraliskForm(int x, int y) {
		super("Hydralisk", x, y);
		
		avatar = new HydraliskAvatar(x, y);
		
		speedSpinner.setValue(8);
		metabolismSpinner.setValue(2);
		hungerSpinner.setValue(3000);
		capacitySpinner.setValue(5000);
	}	
	
}
