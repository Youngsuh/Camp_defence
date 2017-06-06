package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 6. 6..
 */

public class Priencess extends Enemy {
    public Priencess(){
        super(AppManager.getInstance().getBitmap(R.drawable.ch_heroine));
        this.InitSpriteData(200, 87, 10, 10);
        hp = 5;
        speed = 6;
        score = 400;
        Type =5;
    }

    @Override
    public void Update(long GameTime){
        super.Update(GameTime);

        m_BoundBox.set(m_x,m_y,m_x+150,m_y+123);
    }
}
