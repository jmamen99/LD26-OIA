package nl.jerreav.OIA;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

public enum TileShape {
SQUARE,LONG,CORNER;

private static boolean maskCalculated = false;
//indices are shape, size, rotation
private static Pixmap[][][] mask;

public static Pixmap getMask(TileShape shape,int size,int rotation){
	if(false == maskCalculated){
		mask = new Pixmap[3][3][4];
		loadMask();
		maskCalculated = true;
	}
	
	
	int shapeInt = 0;
	switch(shape){
	case SQUARE:
		shapeInt = 0;
		break;
	case LONG:
		shapeInt = 1;
		break;
	case CORNER:
		shapeInt = 2;
		break;
	}
	
	size = (int) (U.log2(size));
	
	
	return mask[shapeInt][size][rotation];

}

private static void loadMask() {
	//indices are shape, size, rotation
	mask[0][0][0] = new Pixmap(Gdx.files.internal("pics/mask/rect_1_1.png"));
	mask[0][1][0] = new Pixmap(Gdx.files.internal("pics/mask/rect_2_1.png"));
	mask[0][2][0] = new Pixmap(Gdx.files.internal("pics/mask/rect_4_1.png"));

	mask[1][1][0] = new Pixmap(Gdx.files.internal("pics/mask/long_2_1.png"));
	mask[1][2][0] = new Pixmap(Gdx.files.internal("pics/mask/long_4_1.png"));
	mask[1][1][1] = new Pixmap(Gdx.files.internal("pics/mask/long_2_2.png"));
	mask[1][2][1] = new Pixmap(Gdx.files.internal("pics/mask/long_4_2.png"));

	mask[2][1][0] = new Pixmap(Gdx.files.internal("pics/mask/corner_2_1.png"));
	mask[2][2][0] = new Pixmap(Gdx.files.internal("pics/mask/corner_4_1.png"));
	mask[2][1][1] = new Pixmap(Gdx.files.internal("pics/mask/corner_2_2.png"));
	mask[2][2][1] = new Pixmap(Gdx.files.internal("pics/mask/corner_4_2.png"));
	mask[2][1][2] = new Pixmap(Gdx.files.internal("pics/mask/corner_2_3.png"));
	mask[2][2][2] = new Pixmap(Gdx.files.internal("pics/mask/corner_4_3.png"));
	mask[2][1][3] = new Pixmap(Gdx.files.internal("pics/mask/corner_2_4.png"));
	mask[2][2][3] = new Pixmap(Gdx.files.internal("pics/mask/corner_4_4.png"));
	
}

}
