package br.com.mibsim.ui.spinner;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.loader.FontLoader;
import br.com.etyllica.gui.spinner.StringSpinner;

public class NutrientSpinner extends StringSpinner {

	private static final Font font = FontLoader.getInstance().loadFont("Suplexmentary_Comic_NC.ttf").deriveFont(22f);
	
	public NutrientSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		
		List<String> options = new ArrayList<String>(2);
		options.add("water");
		options.add("adamant.");
		
		setOptions(options);
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
