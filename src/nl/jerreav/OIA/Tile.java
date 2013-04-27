package nl.jerreav.OIA;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Tile {
	private static Texture tilesTexture = new Texture(Gdx.files.internal("pics/tiles.png"));
	private static TextureRegion[][] tilesRegions = TextureRegion.split(tilesTexture, 2, 2);
	private Sprite tileSprite;
	Pixmap pixMap;
	TileColor 	color;
	Color		activeColor;
	Color		inactiveColor;
	int 		size;
	TileShape 	shape;
	int 				x;
	int 				y;
	private int			rotation;
	boolean		isActive = false;
	Array<Tile> neighbours;
	
	Tile(TileColor _color, int _size, TileShape _shape, int _x, int _y, int _rotation){
		color = _color;
		size = _size;
		shape = _shape;
		x = _x;
		y = _y;
		rotation = _rotation;
		
		neighbours = new Array<Tile>();
		
		switch(shape){
		case SQUARE:
			tileSprite = new Sprite(tilesRegions[0][7]);
			break;
		case LONG:
			tileSprite = new Sprite(tilesRegions[0][1]);
			break;
		case CORNER:
			tileSprite = new Sprite(tilesRegions[0][3]);
			break;
		}
		switch(color){
		case RED:
			activeColor = new Color(1,0,0,1);
			inactiveColor = new Color(1,0.92f,0.92f,1);
			break;
		case YELLOW:
			activeColor = new Color(1,1,0,1);
			inactiveColor = new Color(1,1,0.92f,1);
			break;
		case BLUE:
			activeColor = new Color(0,0,1,1);
			inactiveColor = new Color(0.92f,0.92f,1,1);
			break;
		default:
		}

		tileSprite.setBounds(x, y, size*U.SPRITESIZE, size*U.SPRITESIZE);
		tileSprite.setOrigin(size*U.SPRITESIZE/2, size*U.SPRITESIZE/2);
		
		if(shape == TileShape.LONG){
			tileSprite.setRotation(rotation*-90);
		}
		if(shape == TileShape.CORNER){
			tileSprite.setRotation(rotation*90);
		}
		
		pixMap = TileShape.getMask(shape,size, rotation);
	}
		
	void render(int xOffset, int yOffset){
		
		if(isActive){
			tileSprite.setColor(activeColor);
		}
		else{
			tileSprite.setColor(inactiveColor);
		}
//		Gdx.app.log("Tile", "render");
		tileSprite.setBounds(x+xOffset, y+yOffset, size*U.SPRITESIZE, size*U.SPRITESIZE);
		tileSprite.draw(U.batch);
//		U.font.draw(U.batch,"N:" + neighbours.size,x,y+20);
	}
	
	
	

}
