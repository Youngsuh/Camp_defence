package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

public class Effect_Explosion_2 extends Effect_Explosion {

	public Effect_Explosion_2( int x , int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.ef_yeti_die));
		this.SetPosition(139,120);
		m_x = x;
		m_y = y;
	}

	@Override
	public void Update(long GameTime) {
		super.Update(GameTime);
	}
}
