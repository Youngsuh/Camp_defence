package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

import android.graphics.Bitmap;

public class Item_2 extends Item {

	public Item_2(int x, int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.item_speed_down));
		this.SetPosition(32, 32);
		m_x = x;
		m_y = y;
	}

	@Override
	public void Update(long GameTime) {
		super.Update(GameTime);
	}
}
