package org.Game;

import org.Framework.AppManager;
import org.Framework.R;
import org.Framework.SpriteAnimation;

public class Enemy_1 extends Enemy {
	//IceWolf
	public Enemy_1(){
		super(AppManager.getInstance().getBitmap(R.drawable.ice_wolf));
		this.InitSpriteData(160	, 235, 10, 6);
		//810 90
		hp = 7;
		speed = 5f;
		score = 300;
		Type =1;
	}

	@Override
	public void Update(long GameTime){
		super.Update(GameTime);
		
		m_BoundBox.set(m_x,m_y,m_x+135,m_y+90);
	}
	
}
