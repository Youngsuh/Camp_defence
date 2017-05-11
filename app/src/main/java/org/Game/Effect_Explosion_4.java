package org.Game;

import org.Framework.AppManager;
import org.Framework.R;
import org.Framework.SpriteAnimation;

public class Effect_Explosion_4 extends SpriteAnimation {

	public Effect_Explosion_4(int x , int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.falcon_die));
		this.InitSpriteData(110, 85, 2, 6);
		m_x = x;
		m_y = y;
		mbReply = false;

	}

}
