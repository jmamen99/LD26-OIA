package nl.jerreav.OIA;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
	

	public static Sound[] sine = {Gdx.audio.newSound(Gdx.files.internal("audio/sine_1.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_2.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_3.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_4.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_5.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_6.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_7.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_8.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_9.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_10.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_11.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_12.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_13.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_14.mp3")),
		Gdx.audio.newSound(Gdx.files.internal("audio/sine_15.mp3"))};
	
	
	
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



	private int lastX;
	private int lastX2;
	
	
	Sequencer(GridSocket[][] _sockets, int _sizeX, int _sizeY){
		sockets = _sockets;
		sizeX = _sizeX;
		sizeY = _sizeY;
		y2 = sizeY/2;
		
		time = TimeUtils.millis();
	}
	
	void render(int xOffset, int yOffset){
		if(isPlaying){
			
			U.emptySprite.setColor(0,0,0,0.4f);
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
//					switch(t.color){
//					case RED:
//						piano[2-(int)U.log2(t.size)].play();
//						break;
//					case YELLOW:
//						marimba[2-(int)U.log2(t.size)].play();
//						break;
//					case BLUE:
//						strings[2-(int)U.log2(t.size)].play();
//						break;
//					}
					lastX = (int)((2-U.log2(t.size))*5 + MathUtils.random(4));
				}
				sine[lastX].play(0.5f);
				
				if(toggle){
					x2++;
					if(x2 >= sizeX){
						x2 = 0;
						y2 = (y2+1)%sizeY;
					}
					t = sockets[x2][y2].tile;
					if(t != null && t.isActive){
//						switch(t.color){
//						case RED:
//							piano[2-(int)U.log2(t.size)].play();
//							break;
//						case YELLOW:
//							marimba[2-(int)U.log2(t.size)].play();
//							break;
//						case BLUE:
//							strings[2-(int)U.log2(t.size)].play();
//							break;
//						}
						lastX2 = (int)(U.log2(t.size)*5 + MathUtils.random(4));
					}
					sine[lastX2].play(0.5f);
					toggle = false;
				}
				else{
					toggle = true;
				}
					
			}
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
		if(t.isActive){
//			switch(t.color){
//			case RED:
//				piano[(int)U.log2(t.size)].play();
//				break;
//			case YELLOW:
//				marimba[(int)U.log2(t.size)].play();
//				break;
//			case BLUE:
//				strings[(int)U.log2(t.size)].play();
//				break;
//			}
		}
	}
	
	void stop(){
		isPlaying = false;
	}
}

