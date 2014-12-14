package br.com.mibsim.application;

import java.awt.Color;
import java.awt.Font;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.loader.FontLoader;
import br.com.mibsim.ui.CapacitySpinner;
import br.com.mibsim.ui.HorizontalPanel;
import br.com.mibsim.ui.HorizontalRule;
import br.com.mibsim.ui.HungerThresholdSpinner;
import br.com.mibsim.ui.MetabolismSpinner;
import br.com.mibsim.ui.SpeedSpinner;


public class ConfigurationScreen extends Application {

	private Font font;
	
	private HorizontalRule hr;
	
	private HorizontalPanel panel;
	
	//Specie Configuration
	private SpeedSpinner speedSpinner;
	private CapacitySpinner capacitySpinner;
	private MetabolismSpinner metabolismSpinner;
	private HungerThresholdSpinner hungerSpinner;
	
	public ConfigurationScreen(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		
		font = FontLoader.getInstance().loadFont("Suplexmentary_Comic_NC.ttf").deriveFont(22f);
		
		hr = new HorizontalRule(20, 80, 300, 0);
		
		panel = new HorizontalPanel(16, 40, 700, 0);
		
		speedSpinner = new SpeedSpinner(60, 100, 180, 30);
		capacitySpinner = new CapacitySpinner(60, 140, 180, 30);
		metabolismSpinner = new MetabolismSpinner(60, 180, 180, 30);
		hungerSpinner = new HungerThresholdSpinner(60, 220, 180, 30);
		
		add(speedSpinner);
		add(capacitySpinner);
		add(metabolismSpinner);
		add(hungerSpinner);
		
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
