package nl.jerreav.OIA;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;

public class StartScreen implements Screen {

	Game game;
	String title;
	String subTitle;
	String subTitle2;
	StartInputProcessor startInputProcessor;
	Screen nextScreen;
	
	StartScreen(Game _game){
		game = _game;
		startInputProcessor = new StartInputProcessor(game,this);

	}
	
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor( 0.0f,0.0f, 0.0f, 1.0f );
		Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );	
		
		U.batch.begin();

		U.fontLarge.setColor(0.8f, 0.8f, 0.8f, 1.0f);
		U.font.setColor(0.9f, 0.9f, 0.9f, 1.0f);
		TextBounds tb = U.fontLarge.getBounds(title);
		TextBounds tbSub = U.font.getBounds(subTitle);
		TextBounds tbSub2 = U.font.getBounds(subTitle2);
		U.fontLarge.draw(U.batch, title, U.w/2-tb.width/2, U.h/2+tb.height/2);
		U.font.draw(U.batch,subTitle, U.w/2-tbSub.width/2, U.h/2-tb.height/2-32);
		U.font.draw(U.batch,subTitle2, U.w/2-tbSub2.width/2, U.h/2-tb.height/2-64);
		
//		U.font.draw(U.batch, Integer.toString((int)(1.0f/Gdx.graphics.getDeltaTime()+0.5f)), 0, U.h-0);
		U.batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(startInputProcessor);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
