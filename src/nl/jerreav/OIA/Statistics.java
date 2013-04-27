package nl.jerreav.OIA;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class Statistics {
	int reds,yellows,blues;
	int smalls,mediums,larges;
	int squares,longs,corners;
	int redyellows, yellowblues,bluereds;
	Array<Tile> tiles;
	
	Statistics(Array<Tile> _tiles){
		tiles = _tiles;
		update();
	}

	void update() {
		reds = 0; yellows = 0; blues = 0;
		smalls = 0; mediums = 0; larges = 0;
		squares = 0; longs = 0; corners = 0;
		redyellows = 0; yellowblues = 0; bluereds = 0;
		for(Tile t: tiles){
			if(t.isActive){
				switch(t.color){
				case RED:
					for(Tile n:t.neighbours){
						if(n.isActive && n.color == TileColor.YELLOW){
							redyellows++;
							break;
						}
					}
					reds++;
					break;
				case YELLOW:
					for(Tile n:t.neighbours){
						if(n.isActive && n.color == TileColor.BLUE){
							yellowblues++;
							break;
						}
					}
					yellows++;
					break;
				case BLUE:
					for(Tile n:t.neighbours){
						if(n.isActive && n.color == TileColor.RED){
							bluereds++;
							break;
						}
					}
					blues++;
					break;
				}
				switch(t.shape){
				case SQUARE:
					squares++;break;
				case LONG:
					longs++;break;
				case CORNER:
					corners++;break;
				}
				switch(t.size){
				case 1:
					smalls++;break;
				case 2:
					mediums++;break;
				case 4:
					larges++;break;
				}
			}
		}
		Gdx.app.log("Statistics", "updated");
	}
	
	
}
