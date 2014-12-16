package br.com.mibsim.ui;

import br.com.etyllica.gui.label.TextLabel;
import br.com.mibsim.ui.avatar.MibSimAvatar;
import br.com.mibsim.ui.spinner.CapacitySpinner;
import br.com.mibsim.ui.spinner.HungerThresholdSpinner;
import br.com.mibsim.ui.spinner.MetabolismSpinner;
import br.com.mibsim.ui.spinner.NutrientSpinner;
import br.com.mibsim.ui.spinner.SpeedSpinner;

public class SpinnerForm {
	
	protected TextLabel titleLabel;
	protected MibSimAvatar avatar;
	
	protected NutrientSpinner foodSpinner;
	protected SpeedSpinner speedSpinner;
	protected CapacitySpinner capacitySpinner;
	protected MetabolismSpinner metabolismSpinner;
	protected HungerThresholdSpinner hungerSpinner;
	
	public SpinnerForm(String title, int x, int y) {
		super();
				
		int spinnerW = 180;
		int spinnerH = 32;
		int spacing = 38;
		int offset = 10;
				
		titleLabel = new TextLabel(x, y-106, spinnerW);
		titleLabel.setText(title);
		titleLabel.setFontSize(24);
		
		foodSpinner = new NutrientSpinner(x, y+offset+spacing*0, spinnerW, spinnerH);
		speedSpinner = new SpeedSpinner(x, y+offset+spacing*1, spinnerW, spinnerH);
		metabolismSpinner = new MetabolismSpinner(x, y+offset+spacing*2, spinnerW, spinnerH);
		hungerSpinner = new HungerThresholdSpinner(x, y+offset+spacing*3, spinnerW, spinnerH);
		capacitySpinner = new CapacitySpinner(x, y+offset+spacing*4, spinnerW, spinnerH);
	}
	
	public TextLabel getTitle() {
		return titleLabel;
	}
	
	public MibSimAvatar getAvatar() {
		return avatar;
	}

	public NutrientSpinner getFoodSpinner() {
		return foodSpinner;
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
