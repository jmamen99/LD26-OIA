package nl.jerreav.OIA;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class StartScreen implements Screen {

	Game game;
	String title = "OIA 0.14";
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
		
		U.font.draw(U.batch, title, U.w/2-U.font.getBounds(title).width, U.h/2+U.font.getBounds(title).height);
		
		U.font.setColor(0.5f, 0.5f, 0.5f, 1.0f);
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
