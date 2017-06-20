package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

public class Enemy_3 extends Enemy {
	//bouns
	public Enemy_3(){
		super(AppManager.getInstance().getBitmap(R.drawable.em_bouns));
		this.InitSpriteData(220	, 157, 3, 6);
		hp = 13;
		speed = 2;
		score = 500;
		Type =3;
		//movetype = Enemy.MOVE_PATTERN_3;
	}


	@Override
	public void Update(long GameTime){
		super.Update(GameTime);

		m_BoundBox.set(m_x,m_y,m_x+90,m_y+120);
	}

}
