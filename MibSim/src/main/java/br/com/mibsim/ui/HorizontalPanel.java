package br.com.mibsim.ui;

import br.com.etyllica.layer.ImageLayer;

public class HorizontalPanel extends HorizontalRule {
	
	public HorizontalPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		layer = new ImageLayer("ui/metal_panel.png");
		startPart = 27;
		endPart = 32;
	}
	
}
