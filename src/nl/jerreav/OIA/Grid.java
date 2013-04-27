package nl.jerreav.OIA;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;

public class Grid {
	GridSocket[][] sockets;
	Array<Tile> tiles;
	int sizeX, sizeY;
	
	Grid(int _sizeX, int _sizeY){
		sizeX = _sizeX;
		sizeY = _sizeY;
		
		sockets = new GridSocket[sizeX][sizeY];
		for(int i = 0; i < sizeX; i++){
			for(int j = 0; j < sizeY; j++){
				sockets[i][j] = new GridSocket(i*U.SPRITESIZE,j*U.SPRITESIZE);
			}
		}
		
		
		tiles = new Array<Tile>();

		addNewTile(new Tile(TileColor.BLUE, 4, TileShape.CORNER, 2*U.SPRITESIZE, 0*U.SPRITESIZE, 0));
		addNewTile(new Tile(TileColor.RED, 2, TileShape.CORNER,2*U.SPRITESIZE, 4*U.SPRITESIZE, 1));
		addNewTile(new Tile(TileColor.YELLOW, 2, TileShape.CORNER, 2*U.SPRITESIZE, 6*U.SPRITESIZE, 2));
		addNewTile(new Tile(TileColor.BLUE, 2, TileShape.CORNER, 2*U.SPRITESIZE, 8*U.SPRITESIZE, 3));
		addNewTile(new Tile(TileColor.YELLOW, 1, TileShape.SQUARE, 2*U.SPRITESIZE, 5*U.SPRITESIZE, 0));
		addNewTile(new Tile(TileColor.YELLOW, 4, TileShape.LONG, 4*U.SPRITESIZE, 5*U.SPRITESIZE, 1));
	}

	private void addNewTile(Tile tile) {
		tiles.add(tile);
		Pixmap p = tile.pixMap;
		for(int i = 0; i < p.getWidth(); i++){
			for(int j = 0; j < p.getHeight(); j++){
//				Gdx.app.log("Grid", tile.size + "no ");
				if(p.getPixel(i, j) == Color.rgba8888(1,1,1,1)){
					sockets[tile.x/U.SPRITESIZE+i][tile.y/U.SPRITESIZE-j+p.getHeight()-1].tile = tile;
					Gdx.app.log("Grid", tile.size + " " + tile.x/U.SPRITESIZE+i + " " + tile.y/U.SPRITESIZE+j + " ");
				}
			}
		}
		
	}

	public void render() {
		for(Tile t:tiles){
			t.render();
		}
		for(GridSocket[] sA:sockets){
			for(GridSocket s:sA){
				s.render();
			}
		}
	}

}
