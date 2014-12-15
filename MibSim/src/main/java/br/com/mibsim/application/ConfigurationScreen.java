package br.com.mibsim.application;

import java.awt.Color;
import java.awt.Font;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.loader.FontLoader;
import br.com.mibsim.ui.HorizontalPanel;
import br.com.mibsim.ui.HorizontalRule;
import br.com.mibsim.ui.HydraliskForm;
import br.com.mibsim.ui.LurkerForm;
import br.com.mibsim.ui.SpinnerForm;
import br.com.mibsim.ui.UltraliskForm;


public class ConfigurationScreen extends Application {

	private Font font;
	
	private HorizontalRule hr;
	
	private HorizontalPanel panel;
	
	//Specie Form
	UltraliskForm ultraliskForm;
	HydraliskForm hydraliskForm;
	LurkerForm lurkerForm;
	
	public ConfigurationScreen(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		
		font = FontLoader.getInstance().loadFont("Suplexmentary_Comic_NC.ttf").deriveFont(22f);
		
		hr = new HorizontalRule(20, 80, 300, 0);
		
		panel = new HorizontalPanel(5, 40, 780, 0);
		
		int formY = 150;
		
		ultraliskForm = new UltraliskForm(160, formY);
		hydraliskForm = new HydraliskForm(360, formY);
		lurkerForm = new LurkerForm(560, formY);
		
		addFormViews(ultraliskForm);
		addFormViews(hydraliskForm);
		addFormViews(lurkerForm);
		
		loading = 100;
	}
	
	private void addFormViews(SpinnerForm form) {
		add(form.getTitle());
		add(form.getSpeedSpinner());
		add(form.getMetabolismSpinner());
		add(form.getHungerSpinner());
		add(form.getCapacitySpinner());
	}

	@Override
	public void draw(Graphic g) {
				
		g.setFont(font);
		
		panel.draw(g);
		
		g.setColor(Color.BLACK);
		g.setAlpha(50);
		g.fillRect(panel);
		
		g.setBasicStroke(2f);
		g.setShadowColor(Color.BLACK);
		g.setColor(Color.WHITE);
		g.drawStringBorder("Attributes", 20, 80);
		
		hr.draw(g);		
	}

}
