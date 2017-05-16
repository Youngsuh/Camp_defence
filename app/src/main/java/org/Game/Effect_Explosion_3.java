package org.Game;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;
import org.Framework.SpriteAnimation;

public class Effect_Explosion_3 extends Effect_Explosion {

	public Effect_Explosion_3( int x , int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.bonus_die));
		this.SetPosition(90,120);
		m_x = x;
		m_y = y;

	}

}
