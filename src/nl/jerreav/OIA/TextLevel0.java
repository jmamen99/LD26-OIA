package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class TextLevel0 extends StartScreen{

	TextLevel0(Game _game) {
		super(_game);
		nextScreen = new Level0(game);
		title = "LEVEL 2";
		subTitle = "This One Is Final  -  A Master Minimalist  -  Can Finish This One";
		subTitle2 = "And Then There Is Still  -  The Master Of Masters With  - Under Sixteen Blocks";
	}

}
