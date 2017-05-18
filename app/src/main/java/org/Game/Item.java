package org.Game;

import org.Framework.GraphicObject;
import org.Framework.SpriteAnimation;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Item extends GraphicObject {

	Rect m_BoundBox = new Rect();
	public static final int STATE_NORMAL = 0;
	public static final int STATE_DELETE = 1;
	long m_LastitemEffect = System.currentTimeMillis();
	public int state =  STATE_NORMAL;

	public boolean bOut = false;

	public Item(Bitmap bitmap) {
		super(bitmap);
	}
	


	void Delete(){
		if(System.currentTimeMillis() - m_LastitemEffect >= 1000){
			m_LastitemEffect = System.currentTimeMillis();
			state = STATE_DELETE;
		}
	}

	@Override
	public void Update(long GameTime) {
		super.Update(GameTime);
		Delete();
	}
	
}
