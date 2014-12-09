package br.com.mibsim.ui;

import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.ImageLayer;

public class HorizontalRule extends HorizontalComponent {

	protected ImageLayer layer;
	
	public HorizontalRule(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		layer = new ImageLayer("ui/hr.png");
		startPart = 6;
		endPart = 6;
	}

	@Override
	public void draw(Graphic g) {
		
		int fullWidth = layer.getW();
		
		//Draw Start
		layer.setXImage(0);
		layer.setW(startPart);
		layer.draw(g, x, y);
		
		//Draw Middle
		layer.setW(1);
		layer.setXImage(startPart);
		
		int i = startPart;
		
		for(; i < w - endPart; i += layer.getW()) {
			layer.draw(g, x+i, y);
		}
		
		//Draw End
		layer.setW(endPart);
		layer.setXImage(fullWidth-endPart);
		layer.draw(g, w-endPart, y);
		
		layer.setW(fullWidth);
		
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(GUIEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
