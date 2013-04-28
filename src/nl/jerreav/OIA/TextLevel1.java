package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class TextLevel1 extends StartScreen {

	TextLevel1(Game _game) {
		super(_game);
		nextScreen = new Level1(game);
		title = "LEVEL 3";
		subTitle = "This One Is Final  -  A Master Minimalist  -  Can Finish This One";
		subTitle2 = "And Then There Is Still  -  The Master Of Masters With  - Under Sixteen Blocks";
	}
}
