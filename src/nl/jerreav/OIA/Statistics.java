package nl.jerreav.OIA;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.utils.Array;

public class Statistics {
	int reds,yellows,blues;
	int smalls,mediums,larges;
	int squares,longs,corners;
	int redyellows, yellowblues,bluereds;
	int totalTiles;
	int[] statsArray;
	int[] minima;
	int[] maxima;
	Array<Tile> tiles;

	private static Texture iconsTexture = new Texture(Gdx.files.internal("pics/icons.png"));
	private static TextureRegion[][] icons = TextureRegion.split(iconsTexture, 8, 8);
	private static Texture arrowsTexture = new Texture(Gdx.files.internal("pics/arrows.png"));
	private static TextureRegion[][] arrows = TextureRegion.split(arrowsTexture, 8, 8);
	
	Statistics(Array<Tile> _tiles, int[] _minima, int[] _maxima){
		tiles = _tiles;
		minima = _minima;
		maxima = _maxima;
		statsArray = new int[16];
		update();
	}

	void update() {
		reds = 0; yellows = 0; blues = 0;
		smalls = 0; mediums = 0; larges = 0;
		squares = 0; longs = 0; corners = 0;
		redyellows = 0; yellowblues = 0; bluereds = 0;
		totalTiles = 0;
		for(Tile t: tiles){
			if(t.isActive){
				totalTiles++;
				switch(t.color){
				case RED:
					for(Tile n:t.neighbours){
						if(n.isActive && n.color == TileColor.YELLOW){
							redyellows++;
						}
					}
					reds++;
					break;
				case YELLOW:
					for(Tile n:t.neighbours){
						if(n.isActive && n.color == TileColor.BLUE){
							yellowblues++;
						}
					}
					yellows++;
					break;
				case BLUE:
					for(Tile n:t.neighbours){
						if(n.isActive && n.color == TileColor.RED){
							bluereds++;
						}
					}
					blues++;
					break;
				}
				switch(t.shape){
				case SQUARE:
					squares++;break;
				case LONG:
					longs++;break;
				case CORNER:
					corners++;break;
				}
				switch(t.size){
				case 1:
					smalls++;break;
				case 2:
					mediums++;break;
				case 4:
					larges++;break;
				}
			}
		}

		statsArray[0] = reds;statsArray[1] =  yellows; statsArray[2] = blues;
		statsArray[4] = smalls; statsArray[5] = mediums;statsArray[6] =  larges;
		statsArray[8] = squares; statsArray[9] = longs; statsArray[10] = corners;
		statsArray[12] = redyellows; statsArray[13] = yellowblues; statsArray[14] = bluereds;
		
//		Gdx.app.log("Statistics", "updated");
	}
	
	
	void render(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				int k = j*4+i;
				U.batch.draw(icons[j][i],U.h+U.SPRITESIZE, U.h-(k)*U.SPRITESIZE-U.SPRITESIZE*3/4,U.SPRITESIZE/2,U.SPRITESIZE/2);
				if(k%4 != 3){
					if(statsArray[k] < minima[k]){
						U.font.setColor(1, 0, 0, 1);
						U.batch.draw(arrows[0][0],U.h+U.SPRITESIZE*2, U.h-(k)*U.SPRITESIZE-U.SPRITESIZE*3/4,U.SPRITESIZE/2,U.SPRITESIZE/2);
					}
					else if(statsArray[k] > maxima[k]){
						U.font.setColor(1, 0, 0, 1);
						U.batch.draw(arrows[0][1],U.h+U.SPRITESIZE*2, U.h-(k)*U.SPRITESIZE-U.SPRITESIZE*3/4,U.SPRITESIZE/2,U.SPRITESIZE/2);
					}
					else{
						U.font.setColor(0,1,0,1);
						U.batch.draw(arrows[0][2],U.h+U.SPRITESIZE*2, U.h-(k)*U.SPRITESIZE-U.SPRITESIZE*3/4,U.SPRITESIZE/2,U.SPRITESIZE/2);
					}
					U.font.draw(U.batch, "" + statsArray[k] + " (" + minima[k] + "<->" + maxima[k] + ")",U.h+U.SPRITESIZE*3, U.h-(j*4+i)*U.SPRITESIZE-U.SPRITESIZE*1/4);
				}
			}
		}
	}
	
}
