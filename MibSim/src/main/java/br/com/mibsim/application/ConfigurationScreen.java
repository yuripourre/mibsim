package br.com.mibsim.application;

import java.awt.Color;
import java.awt.Font;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.loader.FontLoader;
import br.com.mibsim.ui.HorizontalPanel;
import br.com.mibsim.ui.HorizontalRule;
import br.com.mibsim.ui.HorizontalSpinner;

public class ConfigurationScreen extends Application {

	private Font font;
	
	private HorizontalRule hr;
	
	private HorizontalPanel panel;
	
	private HorizontalSpinner spinner;
	
	public ConfigurationScreen(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		
		font = FontLoader.getInstance().loadFont("Suplexmentary_Comic_NC.ttf").deriveFont(22f);
		
		hr = new HorizontalRule(20, 80, 300, 0);
		
		panel = new HorizontalPanel(16, 40, 700, 0);
		
		spinner = new HorizontalSpinner(60, 100, 100, 30);
		
		add(spinner);
		
		loading = 100;
	}

	@Override
	public void draw(Graphic g) {
				
		panel.draw(g);
		
		g.setFont(font);		
		g.setBasicStroke(2f);
		g.setShadowColor(Color.BLACK);
		g.setColor(Color.WHITE);
		g.drawStringBorder("Attributes", 20, 80);
		
		hr.draw(g);
	}

}
