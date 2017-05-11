package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

public class Item_AddLife extends Item {
	
	public Item_AddLife(int x,int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.hp_up));

	}

	@Override
	void GetItem(){

	}
}
