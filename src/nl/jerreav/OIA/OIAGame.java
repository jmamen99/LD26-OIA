package nl.jerreav.OIA;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class OIAGame extends Game {
		private OrthographicCamera camera;
		public static final String LOG = OIAGame.class.getSimpleName();
		private FPSLogger fpslogger;
		
		@Override
		public void create() {		
			U.w = Gdx.graphics.getWidth();
			U.h = Gdx.graphics.getHeight();
			
			camera = new OrthographicCamera();
			camera.setToOrtho(false, U.w, U.h);
			
			Gdx.app.log(OIAGame.LOG, "Creating Game...");
			fpslogger = new FPSLogger();
			
			this.setScreen(new AbstractLevel(this));
		}

		@Override
		public void dispose() {
			U.dispose();
		}

		@Override
		public void render() {

			camera.update();
			U.batch.setProjectionMatrix(camera.combined);
			
			super.render();
			
			
//			fpslogger.log();
		}

		@Override
		public void resize(int width, int height) {
			U.w = width;
			U.h = height;
		}

		@Override
		public void pause() {
		}

		@Override
		public void resume() {
		}
}
