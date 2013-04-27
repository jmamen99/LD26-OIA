package nl.jerreav.OIA;

import com.badlogic.gdx.Game;

public class Level1 extends AbstractLevel {

	Level1(Game _game) {
		super(_game);
		grid = new Grid(12,12,"pics/levels/1/");
	}
}
