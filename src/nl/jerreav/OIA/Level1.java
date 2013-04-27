package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class Level1 extends AbstractLevel {
	int[] minima = {5,5,5,0,
			0,0,0,0,
			5,5,5,0,
			5,5,5,0};
	int[] maxima = {8,8,8,0,
			8,8,8,0,
			8,8,8,0,
			8,8,8,0};
	Level1(Game _game) {
		super(_game);
		goal = new Goal(minima,maxima,16);
		grid = new Grid(12,12,"pics/levels/1/",goal);
		nextLevel = new StartScreen(game);
	}
}
