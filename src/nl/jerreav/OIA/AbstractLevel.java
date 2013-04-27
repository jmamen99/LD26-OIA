package nl.jerreav.OIA;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class AbstractLevel implements Screen {

	@Override
	public void render(float delta) {
		
	Gdx.gl.glClearColor( 0.5f,0.5f, 0.5f, 1f );
	Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );	
	
	U.batch.begin();
	
	
	U.font.setColor(0.0f, 0.0f, 0.0f, 1.0f);
	U.font.draw(U.batch, Integer.toString((int)(1.0f/Gdx.graphics.getDeltaTime())), 0, U.h-0);
	U.batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

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
