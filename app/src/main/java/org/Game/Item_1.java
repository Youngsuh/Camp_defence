package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

public class Item_1 extends Item {
	
	public Item_1(int x, int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.item_hp_up));
		this.SetPosition(32, 32);
		m_x = x;
		m_y = y;
	}

	@Override
	public void Update(long GameTime) {
		super.Update(GameTime);
	}
}
