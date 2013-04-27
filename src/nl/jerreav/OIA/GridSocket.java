package nl.jerreav.OIA;

public class GridSocket {
	private int x;
	private int y;
	Tile tile = null;
	Grid grid;
	
	GridSocket(int _x, int _y, Grid _grid){
		x = _x;
		y = _y;
		grid = _grid;
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

	public void calculateNeighbours(int i, int j) {
		if(tile != null){
			if(i > 0 &&
					grid.sockets[i-1][j].tile != tile &&
					false == tile.neighbours.contains(grid.sockets[i-1][j].tile, false)){
				tile.neighbours.add(grid.sockets[i-1][j].tile);
			}
			if(i < grid.sizeX-1 &&
					grid.sockets[i+1][j].tile != tile &&
					 false == tile.neighbours.contains(grid.sockets[i+1][j].tile, false)){
				tile.neighbours.add(grid.sockets[i+1][j].tile);
			}
			if(j > 0 &&
					grid.sockets[i][j-1].tile != tile &&
					 false == tile.neighbours.contains(grid.sockets[i][j-1].tile, false)){
				tile.neighbours.add(grid.sockets[i][j-1].tile);
			}
			if(j < grid.sizeY-1 &&
					grid.sockets[i][j+1].tile != tile &&
					 false == tile.neighbours.contains(grid.sockets[i][j+1].tile, false)){
				tile.neighbours.add(grid.sockets[i][j+1].tile);
			}
		}
		
	}
	
}
