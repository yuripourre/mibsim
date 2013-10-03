package concept;

import java.awt.Color;

import br.com.etyllica.core.video.Grafico;

public class Concept extends Fountain{

	public Concept(int x, int y) {
		super(x, y);
	}

	protected Color color = Color.GREEN;
	
	public void draw(Grafico g){
		g.setColor(color);
		g.fillRect(x*TILE_SIZE, y*TILE_SIZE, w, h);
		
		g.setColor(Color.BLACK);
		g.drawRect(x*TILE_SIZE, y*TILE_SIZE, w, h);
	}
	
}
