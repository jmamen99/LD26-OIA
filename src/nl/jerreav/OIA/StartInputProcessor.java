package nl.jerreav.OIA;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class StartInputProcessor implements InputProcessor {

	Game game;
	StartScreen screen;
	public StartInputProcessor(Game _game, StartScreen _screen) {
		game = _game;
		screen = _screen;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
		case Keys.ESCAPE:
			Gdx.app.exit();
			break;
		case Keys.SPACE:
			game.setScreen(screen.nextScreen);
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screen.nextScreen != null){
			game.setScreen(screen.nextScreen);
		}
		else{
			game.setScreen(new StartScreen(game));
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
