package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class Level0 extends AbstractLevel{
	int[] minima = {2,2,2,0,
			2,2,2,0,
			2,2,2,0,
			2,2,2,0};
	int[] maxima = {4,4,4,0,
			4,4,4,0,
			4,4,4,0,
			4,4,4,0};
	Level0(Game _game) {
		super(_game);
		goal = new Goal(minima,maxima,16);
		grid = new Grid(12,12,"pics/levels/0/",goal);
		nextLevel = new TextLevel1(game);
	}
}
