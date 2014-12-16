package br.com.mibsim.application;

import java.awt.Color;
import java.awt.Font;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.loader.FontLoader;
import br.com.etyllica.theme.Theme;
import br.com.etyllica.theme.ThemeManager;
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
	private UltraliskForm ultraliskForm;
	private HydraliskForm hydraliskForm;
	private LurkerForm lurkerForm;
	
	public ConfigurationScreen(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		
		font = FontLoader.getInstance().loadFont("Suplexmentary_Comic_NC.ttf").deriveFont(22f);
		
		Theme theme = ThemeManager.getInstance().getTheme();
		theme.setFont(font);
		
		hr = new HorizontalRule(20, 158, 700, 0);
		
		panel = new HorizontalPanel(5, 40, 780, 0);
		
		int formY = 168;
		
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
		add(form.getAvatar());
		add(form.getFoodSpinner());
		add(form.getSpeedSpinner());
		add(form.getMetabolismSpinner());
		add(form.getHungerSpinner());
		add(form.getCapacitySpinner());
	}

	@Override
	public void draw(Graphic g) {
				
		g.setFont(font);
		
		panel.draw(g);
		
		final int labelX = 35;
		final int labelY = 200;
		final int spacing = 38;
		
		g.setBasicStroke(2f);
		g.setShadowColor(Color.BLACK);
		g.setColor(Color.WHITE);
		g.drawStringBorder("Attributes", labelX, 130);
				
		g.drawStringBorder("Need:", labelX, labelY);
		g.drawStringBorder("Metabolism:", labelX, labelY+spacing*1);
		g.drawStringBorder("Speed:", labelX, labelY+spacing*2);
		g.drawStringBorder("Hunger T.:", labelX, labelY+spacing*3);
		g.drawStringBorder("Capacity:", labelX, labelY+spacing*4);		
		
		hr.draw(g);		
	}

}
