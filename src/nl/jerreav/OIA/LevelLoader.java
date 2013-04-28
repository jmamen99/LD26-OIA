package nl.jerreav.OIA;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

public class LevelLoader {

	private final static int red = Color.rgba8888(1,0,0,1);
	private final static int yellow = Color.rgba8888(1,1,0,1);
	private final static int blue = Color.rgba8888(0,0,1,1);
	
	
	public static void loadLevel(String path, Grid grid){
		
		readPixmap(grid,path + "r_1_1.png",TileShape.SQUARE,1,0);
		readPixmap(grid,path + "r_2_1.png",TileShape.SQUARE,2,0);
		readPixmap(grid,path + "r_4_1.png",TileShape.SQUARE,4,0);

		readPixmap(grid,path + "c_2_1.png",TileShape.CORNER,2,0);
		readPixmap(grid,path + "c_2_2.png",TileShape.CORNER,2,1);
		readPixmap(grid,path + "c_2_3.png",TileShape.CORNER,2,2);
		readPixmap(grid,path + "c_2_4.png",TileShape.CORNER,2,3);
		
		readPixmap(grid,path + "c_4_1.png",TileShape.CORNER,4,0);
		readPixmap(grid,path + "c_4_2.png",TileShape.CORNER,4,1);
		readPixmap(grid,path + "c_4_3.png",TileShape.CORNER,4,2);
		readPixmap(grid,path + "c_4_4.png",TileShape.CORNER,4,3);

		readPixmap(grid,path + "l_2_1.png",TileShape.LONG,2,0);
		readPixmap(grid,path + "l_2_2.png",TileShape.LONG,2,1);
		readPixmap(grid,path + "l_4_1.png",TileShape.LONG,4,0);
		readPixmap(grid,path + "l_4_2.png",TileShape.LONG,4,1);
		
		
	}

	private static void readPixmap(Grid grid, String path, TileShape shape, int size, int rotation) {
		Pixmap p = new Pixmap(Gdx.files.internal(path));
		for(int i = 0; i < p.getWidth(); i++){
			for(int j = 0; j < p.getHeight(); j++){
				int c = p.getPixel(i, j);
				if(c == red){
//					Gdx.app.log("LevelLoader", "red " + (i*U.SPRITESIZE) + "," + (grid.sizeY*U.SPRITESIZE-j*U.SPRITESIZE-U.SPRITESIZE));
					grid.addNewTile(new Tile(TileColor.RED, size, shape,i*U.SPRITESIZE, grid.sizeY*U.SPRITESIZE-j*U.SPRITESIZE-U.SPRITESIZE, rotation));
				}
				else if(c == yellow){
//					Gdx.app.log("LevelLoader", "yellow  " + (i*U.SPRITESIZE) + "," + (grid.sizeY*U.SPRITESIZE-j*U.SPRITESIZE-U.SPRITESIZE));
					grid.addNewTile(new Tile(TileColor.YELLOW, size, shape,i*U.SPRITESIZE, grid.sizeY*U.SPRITESIZE-j*U.SPRITESIZE-U.SPRITESIZE, rotation));
				}
				else if(c == blue){
//					Gdx.app.log("LevelLoader", "blue " + (i*U.SPRITESIZE) + "," + (grid.sizeY*U.SPRITESIZE-j*U.SPRITESIZE-U.SPRITESIZE));
					grid.addNewTile(new Tile(TileColor.BLUE, size, shape,i*U.SPRITESIZE, grid.sizeY*U.SPRITESIZE-j*U.SPRITESIZE-U.SPRITESIZE, rotation));
				}
			}
		}
	}
}
