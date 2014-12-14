package br.com.mibsim.ui;

import java.awt.Color;

import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.spinner.HorizontalSpinner;

public class MibSimSpinner extends HorizontalSpinner<Integer> {

	public MibSimSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add() {
		if(value.intValue() < maxValue){
			this.value = value.intValue() + step.intValue();
		}
	}

	@Override
	public void subtract() {
		if(value.intValue() > minValue){
			this.value = value.intValue() - step.intValue();
		}
	}
	
	public Integer getValue() {
		return this.value.intValue();
	}

	@Override
	protected void drawResult(Graphic g) {
		g.setColor(Color.WHITE);
		g.drawStringBorder(resultLabel.getLayer().getText(), x, y, w, h);
	}
	
}
