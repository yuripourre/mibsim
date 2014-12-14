package br.com.mibsim.ui;

import java.awt.Color;

import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.Spinner;
import br.com.etyllica.gui.factory.DefaultButton;
import br.com.etyllica.gui.label.TextLabel;

public class HorizontalSpinner extends Spinner<Integer> {

	public HorizontalSpinner(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void configureButtons() {
		
		int buttonWidth = w/6;
		int miniBorder = 1;

		plus = new DefaultButton(x+miniBorder, y+miniBorder, buttonWidth, h-miniBorder*2);
		plus.setLabel(new TextLabel("+"));
		plus.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "addReload"));

		minus = new DefaultButton(x+w-buttonWidth-miniBorder, y+miniBorder, buttonWidth, h-miniBorder*2);
		minus.setLabel(new TextLabel("-"));
		minus.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "subReload"));		
	}
	
	@Override
	protected void drawResult(Graphic g) {
		g.setColor(Color.WHITE);
		g.drawStringBorder(resultLabel.getLayer().getText(), x, y);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subtract() {
		// TODO Auto-generated method stub
		
	}

}
