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

		LevelLoader.loadLevel("pics/levels/1/", this);
//		addNewTile(new Tile(TileColor.YELLOW, 4, TileShape.SQUARE, 11*U.SPRITESIZE, 9*U.SPRITESIZE, 0));
	}

	public void addNewTile(Tile tile) {
		tiles.add(tile);
		Pixmap p = tile.pixMap;
		for(int i = 0; i < p.getWidth(); i++){
			for(int j = 0; j < p.getHeight(); j++){
//				Gdx.app.log("Grid", tile.size + "no ");
				if(p.getPixel(i, j) == Color.rgba8888(1,1,1,1)){
//					Gdx.app.log("Grid", tile.size + " " + (tile.x/U.SPRITESIZE+i) + " " + (tile.y/U.SPRITESIZE+j+p.getHeight()-1) + " ");
					sockets[tile.x/U.SPRITESIZE+i][tile.y/U.SPRITESIZE-j+p.getHeight()-1].tile = tile;
					Gdx.app.log("Grid", tile.size + " " + (tile.x/U.SPRITESIZE+i) + " " + (tile.y/U.SPRITESIZE+j+p.getHeight()-1) + " ");
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
//				s.render();
			}
		}
	}

	public void touchDown(int screenX, int screenY, int pointer, int button) {
		int x = screenX/U.SPRITESIZE;
		int y = (U.h-screenY)/U.SPRITESIZE;
		Gdx.app.log("Grid", "clicked on " + screenX + "," + screenY + " converted to " + x + "," + y);
		if(x < sizeX && y < sizeY){
			sockets[x][y].touchDown(button);
		}
		
		
	}

}
