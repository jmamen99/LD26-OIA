package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class RealStartScreen extends StartScreen{

	RealStartScreen(Game _game) {
		super(_game);
		nextScreen = new TextTutorial1(game);
		title = "OIA 0.14";
		subTitle = "Minimize Puzzles  -  Create Minimal Artworks  -  Click Somewhere To Start";
		subTitle2 = "Made For Compo Of  -  Ludum Dare Twenty Six - Jerre van der Hulst";
	}

}
