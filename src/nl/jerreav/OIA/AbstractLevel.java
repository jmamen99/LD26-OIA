package nl.jerreav.OIA;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class AbstractLevel implements Screen {
	
	Array<Tile> tiles;
	Grid grid;
//	GridSocket[][] grid; 
	Game game;
	GameInputProcessor gameInputProcessor;
	Goal goal;
	Screen nextLevel;
	static Texture quitTexture = new Texture(Gdx.files.internal("pics/quit.png"));
	
	AbstractLevel(Game _game){
		game = _game;
		gameInputProcessor = new GameInputProcessor(this);
	}
	
	

	@Override
	public void render(float delta) {
		
	Gdx.gl.glClearColor( 0.0f,0.0f, 0.0f, 1.0f );
	Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );	
	
	U.batch.begin();
	
	grid.render();
	goal.render();
	
	U.font.setColor(0.5f, 0.5f, 0.5f, 1.0f);
//	U.font.draw(U.batch, Integer.toString((int)(1.0f/Gdx.graphics.getDeltaTime()+0.5f)), 0, U.h-0);

	U.batch.draw(quitTexture,U.w-U.SPRITESIZE,U.SPRITESIZE*3/2,U.SPRITESIZE,U.SPRITESIZE/2);
	U.batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(gameInputProcessor);

		grid.sequencer.start();

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
