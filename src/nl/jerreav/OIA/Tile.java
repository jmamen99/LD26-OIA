package nl.jerreav.OIA;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
	private static Texture tilesTexture = new Texture(Gdx.files.internal("pics/tiles.png"));
	private static TextureRegion[][] tilesRegions = TextureRegion.split(tilesTexture, 2, 2);
	private Sprite tileSprite;
	private TileColor 	color;
	private Color		activeColor;
	private Color		inactiveColor;
	private int 		size;
	private TileShape 	shape;
	private int 		x,y;
	private int			rotation;
	private boolean		isActive = true;
	
	Tile(TileColor _color, int _size, TileShape _shape, int _x, int _y, int _rotation){
		color = _color;
		size = _size;
		shape = _shape;
		x = _x;
		y = _y;
		rotation = _rotation;
		
		
		switch(shape){
		case SQUARE:
			tileSprite = new Sprite(tilesRegions[0][0]);
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
			inactiveColor = new Color(1,0.9f,0.9f,1);
			break;
		case YELLOW:
			activeColor = new Color(1,1,0,1);
			inactiveColor = new Color(1,1,0.9f,1);
			break;
		case BLUE:
			activeColor = new Color(0,0,1,1);
			inactiveColor = new Color(0.9f,0.9f,1,1);
			break;
		default:
		}
		
		tileSprite.setBounds(x, y, size*U.SPRITESIZE, size*U.SPRITESIZE);
		tileSprite.setRotation(rotation*90);
	}
		
	void render(){
		
		if(isActive){
			tileSprite.setColor(activeColor);
		}
		else{
			tileSprite.setColor(inactiveColor);
		}
//		Gdx.app.log("Tile", "render");
		tileSprite.draw(U.batch);
		
	}
	
	
	

}
