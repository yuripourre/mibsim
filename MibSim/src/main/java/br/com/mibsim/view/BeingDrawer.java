package br.com.mibsim.view;

import java.awt.Color;

import application.MibSimApplication;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.mibsim.model.beign.Being;
import br.com.mibsim.model.beign.BeingListener;

public class BeingDrawer implements BeingListener {
	
	private Being being;
	
	protected AnimatedLayer layer;
	
	private boolean onMouse = false;	
	
	public BeingDrawer(Being being) {
		super();
		
		this.being = being;
		
		layer = new AnimatedLayer(being.getX(), being.getY(), MibSimApplication.TILE_SIZE, MibSimApplication.TILE_SIZE);
		
		layer.setFrames(3);
		
		layer.setAnimateHorizontally(false);		
	}

	public Being getBeing() {
		return being;
	}

	public void setBeing(Being being) {
		this.being = being;
	}

	public AnimatedLayer getLayer() {
		return layer;
	}

	public void setLayer(AnimatedLayer layer) {
		this.layer = layer;
	}
	
	public void draw(Graphic g) {
		
		g.setColor(being.getBloodColor());
		g.fillOval(layer.getX(), layer.getY(), layer.getTileW(), layer.getTileH());

		g.setAlpha(100);
		
		layer.draw(g);
		
	}

	public void drawInteractionRadius(Graphic g) {
		g.setColor(Color.BLACK);
		g.setAlpha(70);
		g.fillCircle(layer.getX()+layer.getTileW()/2, layer.getY()+layer.getTileH()/2, being.getInteractionRadius());
		g.setAlpha(100);
	}
	
	public void drawEnergyBar(Graphic g) {
		
		int x = layer.getX();
		int y = layer.getY();
		int w = layer.getW();
		int h = layer.getH();
				
		g.setColor(Color.BLACK);
		g.fillRect(x-1, y-h/4, w+2, 4);
		
		float energyFactor = being.getFullEnergy()/being.getEnergy();
				
		g.setColor(Color.GREEN);
		g.fillRect(x, y-h/4+1, w*energyFactor, 2);
		
	}
	
	public boolean isOnMouse() {
		return onMouse;
	}

	public void setOnMouse(boolean onMouse) {
		this.onMouse = onMouse;
	}

	@Override
	public void onWalk() {
		layer.animate();
	}
	
	@Override
	public void goLeft() {
		layer.setXImage(1*MibSimApplication.TILE_SIZE);
	}
	
	@Override
	public void goRight() {
		layer.setXImage(3*MibSimApplication.TILE_SIZE);
	}
	
	@Override
	public void goUp() {
		layer.setXImage(0*MibSimApplication.TILE_SIZE);
	}
	
	@Override
	public void goDown() {
		layer.setXImage(2*MibSimApplication.TILE_SIZE);
	}
	
}
