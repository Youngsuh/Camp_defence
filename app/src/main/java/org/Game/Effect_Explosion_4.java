package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

public class Effect_Explosion_4 extends Effect_Explosion {

	public Effect_Explosion_4(int x , int y) {
		super(AppManager.getInstance().getBitmap(R.drawable.ef_falcon_die));
		this.SetPosition(90,120);

		m_x = x;
		m_y = y;

	}

	@Override
	public void Update(long GameTime) {
		super.Update(GameTime);
	}
}
