package org.Game;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;
import org.Framework.SpriteAnimation;

import android.graphics.Bitmap;

public class Effect_Explosion_1 extends Effect_Explosion {
	public Effect_Explosion_1( int x , int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.ice_wolf_die));
		this.SetPosition(109, 110);
		m_x = x;
		m_y = y;
	}

}
