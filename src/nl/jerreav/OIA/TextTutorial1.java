package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class TextTutorial1 extends StartScreen {

	TextTutorial1(Game _game) {
		super(_game);
		nextScreen = new LevelTutorial1(game);
		title = "LEVEL 1";
		subTitle = "Make Blocks White With Click  -  Reach Every Goal On The Right  -  Then Click To Advance";
		subTitle2 = "The Big Gray Number  -  Will Be Green When You're Finished  -  Minimalize It";
	}
	
}
