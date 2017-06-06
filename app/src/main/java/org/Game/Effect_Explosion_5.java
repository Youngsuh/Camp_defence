package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 6. 6..
 */

public class Effect_Explosion_5 extends Effect_Explosion {
    public Effect_Explosion_5(int x , int y) {
        super(AppManager.getInstance().getBitmap(R.drawable.ch_heroine_die));
        this.SetPosition(90,120);

        m_x = x;
        m_y = y;

    }

    @Override
    public void Update(long GameTime) {
        super.Update(GameTime);
    }
}
