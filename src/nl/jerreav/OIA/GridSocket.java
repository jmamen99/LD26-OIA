package nl.jerreav.OIA;

public class GridSocket {
	private int x;
	private int y;
	Tile tile = null;
	
	GridSocket(int _x, int _y){
		x = _x;
		y = _y;
	}

	public void render() {
		if(tile != null){
			U.emptySprite.setColor(tile.inactiveColor);
			U.emptySprite.setBounds(x, y, 10, 10);
			U.emptySprite.draw(U.batch);
		}
	}

	public void touchDown(int button) {


		if(tile != null){
			tile.isActive = !tile.isActive;
		}
	}
	
}
