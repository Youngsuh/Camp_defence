package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

import android.graphics.Bitmap;

public class Item_AddScore extends Item {

	public Item_AddScore(int x,int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.item1));
		this.InitSpriteData(51	, 51, 3, 4);		
		
		m_x = x;
		m_y = y;
	}

	@Override
	void GetItem(){
		AppManager.getInstance().m_gamestate.m_score += 100;
	}
}
