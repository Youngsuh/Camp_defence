package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 6. 6..
 */

public class Safty_Priencess extends Enemy {
    public Safty_Priencess(){
        super(AppManager.getInstance().getBitmap(R.drawable.ch_heroine));
        this.InitSpriteData(200, 87, 10, 10);
        hp = 5;
        speed = 6;
        score = 0;
        Type =5;
    }

    @Override
    public void Update(long GameTime){
        super.Update(GameTime);

        m_BoundBox.set(m_x,m_y,m_x+100,m_y+90);
    }
}
