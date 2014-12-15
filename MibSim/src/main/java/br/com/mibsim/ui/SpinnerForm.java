package br.com.mibsim.ui;

import br.com.etyllica.gui.label.TextLabel;
import br.com.mibsim.ui.spinner.CapacitySpinner;
import br.com.mibsim.ui.spinner.HungerThresholdSpinner;
import br.com.mibsim.ui.spinner.MetabolismSpinner;
import br.com.mibsim.ui.spinner.SpeedSpinner;

public class SpinnerForm {
	
	protected TextLabel titleLabel;
	
	protected SpeedSpinner speedSpinner;
	protected CapacitySpinner capacitySpinner;
	protected MetabolismSpinner metabolismSpinner;
	protected HungerThresholdSpinner hungerSpinner;
	
	public SpinnerForm(String title, int x, int y) {
		super();
				
		int spinnerW = 180;
		int spinnerH = 30;
		
		titleLabel = new TextLabel(x, y-100, spinnerW);
		titleLabel.setText(title);
		
		speedSpinner = new SpeedSpinner(x, y+40*0, spinnerW, spinnerH);
		metabolismSpinner = new MetabolismSpinner(x, y+40*1, spinnerW, spinnerH);
		hungerSpinner = new HungerThresholdSpinner(x, y+40*2, spinnerW, spinnerH);
		capacitySpinner = new CapacitySpinner(x, y+40*3, spinnerW, spinnerH);
	}
	
	public TextLabel getTitle() {
		return titleLabel;
	}

	public SpeedSpinner getSpeedSpinner() {
		return speedSpinner;
	}

	public CapacitySpinner getCapacitySpinner() {
		return capacitySpinner;
	}

	public MetabolismSpinner getMetabolismSpinner() {
		return metabolismSpinner;
	}

	public HungerThresholdSpinner getHungerSpinner() {
		return hungerSpinner;
	}
		
}
