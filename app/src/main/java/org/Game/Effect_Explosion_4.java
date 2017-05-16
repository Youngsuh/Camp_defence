package org.Game;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;
import org.Framework.SpriteAnimation;

public class Effect_Explosion_4 extends Effect_Explosion {

	public Effect_Explosion_4(int x , int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.falcon_die));
		this.SetPosition(90,120);

		m_x = x;
		m_y = y;

	}

}
