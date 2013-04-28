package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class LevelTutorial1 extends AbstractLevel {
	
	int[] minima = {1,1,1,0,
					0,0,3,0,
					1,1,1,0,
					1,1,1,0};
	int[] maxima = {2,2,2,0,
					0,0,9,0,
					2,2,2,0,
					2,2,2,0};

	LevelTutorial1(Game _game) {
		super(_game);
		goal = new Goal(minima,maxima,5);
		grid = new Grid(12,12,"pics/levels/tut/",goal);
		nextLevel = new TextLevel1(game);
	}
}
