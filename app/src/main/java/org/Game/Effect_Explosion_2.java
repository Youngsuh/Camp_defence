package org.Game;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;
import org.Framework.SpriteAnimation;

public class Effect_Explosion_2 extends GraphicObject {

	public Effect_Explosion_2(int num, int x , int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.yeti_die));
		this.SetPosition(139,120);
		m_x = x;
		m_y = y;


	}

}
