package br.com.mibsim.editor;

import br.com.vite.map.MapType;
import br.com.vite.tile.set.TileSet;

public class ZergTileSet extends TileSet {

	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;

	public ZergTileSet() {
		super(384/TILE_WIDTH, 96/TILE_WIDTH, TILE_WIDTH, TILE_HEIGHT, MapType.ORTHOGONAL, "tiles/tileset.png");
	}

}
