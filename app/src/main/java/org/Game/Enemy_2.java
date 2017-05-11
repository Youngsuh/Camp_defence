package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

import android.graphics.Bitmap;

public class Enemy_2 extends Enemy {
	//Yeti
	public Enemy_2(){
		super(AppManager.getInstance().getBitmap(R.drawable.yeti));
		this.InitSpriteData(210	, 175, 8, 7);
		//700 120
		hp = 10;
		speed = 3;
		score = 1000;
		Type =2;
		//movetype = Enemy.MOVE_PATTERN_3;
	}

	@Override
	public void Update(long GameTime){
		super.Update(GameTime);

		m_BoundBox.set(m_x,m_y,m_x+136,m_y+120);
	}

}
