package nl.jerreav.OIA;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.utils.Array;

public class Grid {
	GridSocket[][] sockets;
	Array<Tile> tiles;
	int sizeX, sizeY;
	Statistics statistics;
	Sequencer sequencer;
	Goal goal;
	private int yOffset = (int)(1.5*U.SPRITESIZE);
	private int xOffset = (int)(1.5*U.SPRITESIZE);
	Texture vink = new Texture(Gdx.files.internal("pics/vink.png"));
	
	
	Grid(int _sizeX, int _sizeY, String path, Goal _goal){
		sizeX = _sizeX;
		sizeY = _sizeY;
		goal = _goal;
		
		sockets = new GridSocket[sizeX][sizeY];
		for(int i = 0; i < sizeX; i++){
			for(int j = 0; j < sizeY; j++){
				sockets[i][j] = new GridSocket(i*U.SPRITESIZE,j*U.SPRITESIZE,this);
			}
		}
		
		
		tiles = new Array<Tile>();

		LevelLoader.loadLevel(path, this);
		calculateNeighbours();
		statistics = new Statistics(tiles,goal.minima,goal.maxima);
		sequencer = new Sequencer(sockets, sizeX, sizeY);
	}

	private void calculateNeighbours() {
		for(int i = 0; i < sizeX; i++){
			for (int j = 0; j < sizeY; j++){
				sockets[i][j].calculateNeighbours(i,j);
			}
		}
	}

	public void addNewTile(Tile tile) {
		tiles.add(tile);
		Pixmap p = tile.pixMap;
		for(int i = 0; i < p.getWidth(); i++){
			for(int j = 0; j < p.getHeight(); j++){
//				Gdx.app.log("Grid", tile.size + "no ");
				if(p.getPixel(i, j) == Color.rgba8888(1,1,1,1)){
					sockets[tile.x/U.SPRITESIZE+i][tile.y/U.SPRITESIZE-j+p.getHeight()-1].tile = tile;
//					Gdx.app.log("Grid", tile.size + " " + (tile.x/U.SPRITESIZE+i) + " " + (tile.y/U.SPRITESIZE+j+p.getHeight()-1) + " ");
				}
			}
		}
		
	}

	public void render() {
		for(Tile t:tiles){
			t.render(xOffset,yOffset);
		}
		for(GridSocket[] sA:sockets){
			for(GridSocket s:sA){
//				s.render();
			}
		}
		sequencer.render(xOffset, yOffset);
		statistics.render();
		
		if(goal.isReached){
			U.fontLarge.setColor(0,1,0,1);
			U.batch.draw(vink, U.w-4*U.SPRITESIZE, 10*U.SPRITESIZE, 4*U.SPRITESIZE, 4*U.SPRITESIZE);
		}
		else{
			U.fontLarge.setColor(0.5f,0.5f,0.5f,1);
		}
		TextBounds tb = U.fontLarge.getBounds("" + statistics.totalTiles);
		U.fontLarge.draw(U.batch, "" + statistics.totalTiles, U.w-tb.width , U.h/2+tb.height/2);
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		boolean advanceLevel = false;
		int x = (screenX-xOffset)/U.SPRITESIZE;
		int y = (U.h-screenY-yOffset)/U.SPRITESIZE;
//		Gdx.app.log("Grid", "clicked on " + screenX + "," + screenY + " converted to " + x + "," + y);
		if(x < sizeX && x >= 0 &&
				y < sizeY && y >= 0){
			sockets[x][y].touchDown(button);
			statistics.update();
			goal.checkGoal(statistics.statsArray);
		}
		else {
			advanceLevel = goal.isReached;
		}
		return advanceLevel;
	}

}
