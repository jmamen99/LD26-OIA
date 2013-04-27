package nl.jerreav.OIA;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.utils.Array;

public class AbstractLevel implements Screen {
	
	Array<Tile> tiles;
	Game game;
	
	AbstractLevel(Game _game){
		game = _game;
		tiles = new Array<Tile>();
		tiles.add(new Tile(TileColor.BLUE, 2, TileShape.CORNER, 100, 100, 0));
		tiles.add(new Tile(TileColor.RED, 2, TileShape.CORNER, 100, 200, 3));
		tiles.add(new Tile(TileColor.YELLOW, 2, TileShape.CORNER, 100, 300, 2));
		tiles.add(new Tile(TileColor.BLUE, 2, TileShape.CORNER, 100, 400, 1));
		
	}
	
	

	@Override
	public void render(float delta) {
		
	Gdx.gl.glClearColor( 0.0f,0.0f, 0.0f, 1.0f );
	Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );	
	
	U.batch.begin();
	
	for(Tile t:tiles){
		t.render();
	}
	
	U.font.setColor(0.5f, 0.5f, 0.5f, 1.0f);
	U.font.draw(U.batch, Integer.toString((int)(1.0f/Gdx.graphics.getDeltaTime()+0.5f)), 0, U.h-0);
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
