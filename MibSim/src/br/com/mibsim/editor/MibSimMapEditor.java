package br.com.mibsim.editor;


import java.io.FileNotFoundException;

import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.vite.MapApplication;
import br.com.vite.editor.OrthogonalMapEditor;
import br.com.vite.export.MapExporter;
import br.com.vite.map.selection.OrthogonalFloorSelection;

public class MibSimMapEditor extends MapApplication {

	final int tileWidth = 32;
	final int tileHeight = 32;

	private int tileSetOffsetY = 440;

	private OrthogonalFloorSelection selectionZergMap;
	
	public MibSimMapEditor(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		final int columns = 25;
		final int lines = 18;

		editor = new OrthogonalMapEditor(columns, lines, tileWidth, tileHeight);
		editor.translateMap(0, 20);

		loading = 30;

		ZergTileSet egyptianSet = new ZergTileSet();
				
		selectionZergMap = new OrthogonalFloorSelection(tileWidth, tileHeight, egyptianSet);
		selectionZergMap.translateMap(10, tileSetOffsetY);
		selectionZergMap.setListener(editor);
				
		loading = 80;

		updateAtFixedRate(80);

		loading = 100;
	}
	
	@Override
	public void timeUpdate(long now) {
		super.timeUpdate(now);

		selectionZergMap.update(now);
	}

	private boolean shiftLeft = false;
	private boolean shiftRight = false;

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		super.updateKeyboard(event);
		
		if(event.isKeyDown(KeyEvent.TSK_SHIFT_LEFT)) {
			shiftLeft = true;
		} else if(event.isKeyUp(KeyEvent.TSK_SHIFT_LEFT)) {
			shiftLeft = false;			 
		}

		if(event.isKeyDown(KeyEvent.TSK_SHIFT_LEFT)) {
			shiftRight = true;
		} else if(event.isKeyUp(KeyEvent.TSK_SHIFT_LEFT)) {
			shiftRight = false;			 
		}

		if(shiftLeft||shiftRight) {
			handleSaveMap(event);
		} else {
			handleLoadMap(event);
		}

		return GUIEvent.NONE;
	}

	private void handleSaveMap(KeyEvent event) {

		if(event.isKeyDown(KeyEvent.TSK_1)) {
			MapExporter.export(editor, "map1.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_2)) {
			MapExporter.export(editor, "map2.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_3)) {
			MapExporter.export(editor, "map3.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_4)) {
			MapExporter.export(editor, "map4.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_5)) {
			MapExporter.export(editor, "map5.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_6)) {
			MapExporter.export(editor, "map6.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_7)) {
			MapExporter.export(editor, "map7.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_8)) {
			MapExporter.export(editor, "map8.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_9)) {
			MapExporter.export(editor, "map9.json");
		}
		if(event.isKeyDown(KeyEvent.TSK_0)) {
			MapExporter.export(editor, "map10.json");
		}
	}

	private void handleLoadMap(KeyEvent event) {

		String path = "";
		boolean toLoad = false;

		if(event.isKeyDown(KeyEvent.TSK_1)) {
			path = "map1.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_2)) {
			path = "map2.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_3)) {
			path = "map3.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_4)) {
			path = "map4.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_5)) {
			path = "map5.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_6)) {
			path = "map6.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_7)) {
			path = "map7.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_8)) {
			path = "map8.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_9)) {
			path = "map9.json";
			toLoad = true;
		}
		
		if(event.isKeyDown(KeyEvent.TSK_0)) {
			path = "map10.json";
			toLoad = true;
		}
		
		if(toLoad) {
			
			try {
				
				editor = MapExporter.reload(editor, path);
				
				selectionZergMap.setListener(editor);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}		
		
		/*if(event.isKeyDown(KeyEvent.TSK_Z)) {
			editor.setObjectTile(traps.get(0));
		} else if(event.isKeyDown(KeyEvent.TSK_X)) {
			editor.setObjectTile(traps.get(1));
		}*/
	}


	@Override
	public GUIEvent updateMouse(PointerEvent event) {				
		super.updateMouse(event);

		selectionZergMap.updateMouse(event);

		return GUIEvent.NONE;
	}

	@Override
	public void draw(Graphic g) {
		super.draw(g);

		selectionZergMap.draw(g);
	}

}
