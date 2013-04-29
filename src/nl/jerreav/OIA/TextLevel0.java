package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class TextLevel0 extends StartScreen{

	TextLevel0(Game _game) {
		super(_game);
		nextScreen = new Level0(game);
		title = "LEVEL 2";
		subTitle = "First Real Challenge  -  Has Multiple Solutions  -  But Just One Smallest";
		subTitle2 = "Take Your Time To Think  -  Enjoy The View And Music  -  And Minimalize";
	}

}
