package br.com.mibsim.ui.spinner;

import java.awt.Color;
import java.awt.Font;

import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.loader.FontLoader;
import br.com.etyllica.gui.spinner.HorizontalSpinner;

public class MibSimSpinner extends HorizontalSpinner<Integer> {

	private static final Font font = FontLoader.getInstance().loadFont("Suplexmentary_Comic_NC.ttf").deriveFont(22f);
	
	public MibSimSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
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
	
	@Override
	public void draw(Graphic g) {
		g.setFont(font);
		
		super.draw(g);
	}
	
}
