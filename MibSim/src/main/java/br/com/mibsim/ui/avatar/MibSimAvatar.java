package br.com.mibsim.ui.avatar;

import java.awt.Color;

import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.label.ImageLabel;

public class MibSimAvatar extends ImageLabel {

	public MibSimAvatar(int x, int y) {
		super(x, y, "avatars.png");
		
		layer.setW(94);
		layer.setH(64);	
		
		layer.setCoordinates(x+42, y-84);
	}
	
	@Override
	public void draw(Graphic g) {
		super.draw(g);
		
		g.setBasicStroke(1f);
		g.setColor(Color.WHITE);
		g.drawRect(layer);
	}

}
