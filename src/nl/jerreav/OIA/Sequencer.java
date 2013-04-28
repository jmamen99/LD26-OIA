package nl.jerreav.OIA;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class Sequencer {
//	public static Sound[] piano = {Gdx.audio.newSound(Gdx.files.internal("audio/piano_low.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/piano_mid.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/piano_high.mp3"))};
//
//	public static Sound[] marimba = {Gdx.audio.newSound(Gdx.files.internal("audio/marimba_low.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/marimba_mid.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/marimba_high.mp3"))};
//	
//	public static Sound[] strings = {Gdx.audio.newSound(Gdx.files.internal("audio/strings_low.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/strings_mid.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/strings_high.mp3"))};

	private static Texture musicTexture = new Texture(Gdx.files.internal("pics/music.png"));
	private static TextureRegion[][] musicRegions = TextureRegion.split(musicTexture, 16, 8);

//	public static Sound[] sine = {Gdx.audio.newSound(Gdx.files.internal("audio/sine_1.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_2.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_3.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_4.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_5.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_6.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_7.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_8.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_9.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_10.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_11.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_12.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_13.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_14.mp3")),
//		Gdx.audio.newSound(Gdx.files.internal("audio/sine_15.mp3"))};
	public static Sound[] isine = {Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_1.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_2.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_3.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_4.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_5.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_6.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_7.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_8.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_9.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_10.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_11.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_12.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_13.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_14.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/i/sine_15.mp3"))};
	public static Sound[] asine = {Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_1.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_2.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_3.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_4.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_5.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_6.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_7.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_8.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_9.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_10.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_11.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_12.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_13.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_14.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/a/sine_15.mp3"))};
	public static Sound[] usine = {Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_1.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_2.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_3.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_4.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_5.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_6.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_7.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_8.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_9.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_10.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_11.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_12.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_13.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_14.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/u/sine_15.mp3"))};
	
	
	GridSocket[][] sockets;
	boolean isPlaying = false;
	int x = 0;
	int y = 0;
	int x2 = 0;
	int y2 = 0;
	int sizeX = 0;
	int sizeY = 0;
	private long time = 0;
	final static long timeDif = 200;
	boolean toggle = false;
	
	private Sound soundX;
	private Sound soundX2;
	
	
	Sequencer(GridSocket[][] _sockets, int _sizeX, int _sizeY){
		sockets = _sockets;
		sizeX = _sizeX;
		sizeY = _sizeY;
		y2 = sizeY/2;
		
		time = TimeUtils.millis();
	}
	
	void render(int xOffset, int yOffset){
		if(isPlaying){
			
			U.emptySprite.setColor(1,1,1,1f);
			U.drawRectOutLines(U.batch, x*U.SPRITESIZE+xOffset, y*U.SPRITESIZE+yOffset, U.SPRITESIZE, U.SPRITESIZE, 2);
			U.drawRectOutLines(U.batch, x2*U.SPRITESIZE+xOffset, y2*U.SPRITESIZE+yOffset, U.SPRITESIZE, U.SPRITESIZE, 2);
			
			if(TimeUtils.millis()-time > timeDif){

				x++;
				if(x >= sizeX){
					x = 0;
					y = (y+1)%sizeY;
				}
//				Gdx.app.log("Sequencer", "x:" + x +", y: " +y);
				time += timeDif;
				Tile t = sockets[x][y].tile;
				if(t != null && t.isActive){
					switch(t.color){
					case RED:
						soundX = asine[(int)((2-U.log2(t.size))*5 + MathUtils.random(5))%15];
						break;
					case YELLOW:
						soundX = isine[(int)((2-U.log2(t.size))*5 + MathUtils.random(5))%15];
						break;
					case BLUE:
						soundX = usine[(int)((2-U.log2(t.size))*5 + MathUtils.random(5))%15];
						break;
					}
				}
				soundX.play(MathUtils.random(0.4f, 0.5f));
				
				if(toggle){
					x2++;
					if(x2 >= sizeX){
						x2 = 0;
						y2 = (y2+1)%sizeY;
					}
					t = sockets[x2][y2].tile;
					if(t != null && t.isActive){
						switch(t.color){
						case RED:
							soundX2 = asine[(int)((2-U.log2(t.size))*5 + MathUtils.random(5))%15];
							break;
						case YELLOW:
							soundX2 = isine[(int)((2-U.log2(t.size))*5 + MathUtils.random(5))%15];
							break;
						case BLUE:
							soundX2 = usine[(int)((2-U.log2(t.size))*5 + MathUtils.random(5))%15];
							break;
						}
						
					}
					soundX2.play(MathUtils.random(0.4f, 0.5f));
					toggle = false;
				}
				else{
					toggle = true;
				}
					
			}
			U.batch.draw(musicRegions[0][1],U.w-U.SPRITESIZE,U.SPRITESIZE/2,U.SPRITESIZE,U.SPRITESIZE/2);
		}
		else{
			U.batch.draw(musicRegions[0][0],U.w-U.SPRITESIZE,U.SPRITESIZE/2,U.SPRITESIZE,U.SPRITESIZE/2);
		}
	}
	
	void start(){
		isPlaying = true;
		time = TimeUtils.millis();
		x = 0;
		y = 0;
		x2 = 0;
		y2 = sizeY/2;
		Tile t = sockets[x][y].tile;
		toggle = false;
		soundX = asine[0];
		soundX2 = asine[0];
	}
	
	void stop(){
		isPlaying = false;
	}
}

