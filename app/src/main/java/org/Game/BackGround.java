package org.Game;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BackGround extends GraphicObject {




	public BackGround() {
		super(AppManager.getInstance().getBitmap(R.drawable.main_bg_refair));
	}

	@Override
	public void Update(long GameTime) {
	}

	@Override
	public void Draw(Canvas canvas){
		Bitmap m_bitmap_scale = Bitmap.createScaledBitmap(m_bitmap, AppManager.getInstance().getGameView().getWidth(),
				AppManager.getInstance().getGameView().getHeight(), true);
		canvas.drawBitmap(m_bitmap_scale,m_x,m_y,null);
	}

}
