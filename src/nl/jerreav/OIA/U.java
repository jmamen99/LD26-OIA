package nl.jerreav.OIA;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class U {

	public final static ShapeRenderer shapeRenderer = new ShapeRenderer();
	public final static BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/pix16.fnt"),
			Gdx.files.internal("fonts/pix16.png"),false);
	public final static Texture emptyTexture = new Texture(Gdx.files.internal("pics/empty.png"));
	public final static Sprite emptySprite = new Sprite(emptyTexture);
	public final static SpriteBatch batch = new SpriteBatch();
	public static int w,h;
	public final static int SPRITESIZE = 32;
	
	static float map(float n, float inMin, float inMax, float outMin, float outMax ){
		float out = 0.0f;
		
		out = (n-inMin)/(inMax-inMin);
		out = out*(outMax-outMin)+outMin;
		
		return out;
	}
	
	public static void drawRectOutLines(SpriteBatch batch,float x, float y, float width, float height, float lineWeight){
		emptySprite.setBounds(x,y,width+lineWeight,lineWeight);
		emptySprite.draw(batch);
		emptySprite.setBounds(x,y+height,width+lineWeight,lineWeight);
		emptySprite.draw(batch);
		emptySprite.setBounds(x,y,lineWeight,height);
		emptySprite.draw(batch);
		emptySprite.setBounds(x+width,y,lineWeight,height);
		emptySprite.draw(batch);
	}

	public static void dispose() {
		shapeRenderer.dispose();
		font.dispose();
		emptyTexture.dispose();
	}

	public static float log2(float size) {
		
		return (float) (Math.log(size)/Math.log(2));
	}

}
