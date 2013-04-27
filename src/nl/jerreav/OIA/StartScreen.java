package nl.jerreav.OIA;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;

public class StartScreen implements Screen {

	Game game;
	String title = "OIA 0.14";
	String subTitle = "Minimize Puzzles  -  Create Minimal Artworks  -  Click Somewhere To Start";
	StartInputProcessor startInputProcessor;
	
	StartScreen(Game _game){
		game = _game;
		startInputProcessor = new StartInputProcessor(game);

	}
	
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor( 0.0f,0.0f, 0.0f, 1.0f );
		Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );	
		
		U.batch.begin();

		U.fontLarge.setColor(0.8f, 0.8f, 0.8f, 1.0f);
		U.font.setColor(0.5f, 0.5f, 0.5f, 1.0f);
		TextBounds tb = U.fontLarge.getBounds(title);
		TextBounds tbSub = U.font.getBounds(subTitle);
		U.fontLarge.draw(U.batch, title, U.w/2-tb.width/2, U.h/2+tb.height/2);
		U.font.draw(U.batch,subTitle, U.w/2-tbSub.width/2, U.h/2-tb.height/2-16);
		
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
