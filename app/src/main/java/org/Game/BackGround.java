package org.Game;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class BackGround extends GraphicObject {


	

	
	public BackGround(int backtype) {
		super(AppManager.getInstance().getBitmap(R.drawable.main_background));
	}
	void Update(long GameTime){


	} 
	@Override
	public void Draw(Canvas canvas){
		canvas.drawBitmap(m_bitmap,m_x,m_y,null);
	}

}
