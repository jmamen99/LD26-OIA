package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class EndScreen extends StartScreen {

	EndScreen(Game _game) {
		super(_game);
		nextScreen = null;
		title = "FIN";
		subTitle = "I Hope You Enjoyed  -  Let Me Give You Some Insights:  -  mOndrIAn's Vowels";
		subTitle2 = "All Texts Are Haikus  -  The Music Is Adaptive  -  Sounds Are O,I,A";
	} 

}
