package nl.jerreav.OIA;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;

public class GameInputProcessor implements InputProcessor {
	
	AbstractLevel level;

	public GameInputProcessor(AbstractLevel _level) {
		level = _level;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
		case Keys.ESCAPE:
		case Keys.Q:
			level.game.setScreen(new RealStartScreen(level.game));
			break;
		case Keys.S:
			if(level.grid.sequencer.isPlaying){
				level.grid.sequencer.stop();
			}
			else{
				level.grid.sequencer.start();
			}
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
		if(level.grid.touchDown(screenX,screenY,pointer,button)){
			level.game.setScreen(level.nextLevel);
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
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


