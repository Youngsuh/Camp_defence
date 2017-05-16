package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 4. 13..
 */

public class Enemy_4 extends Enemy{
    //Falcon
    public Enemy_4(){
        super(AppManager.getInstance().getBitmap(R.drawable.em_falcon));
        this.InitSpriteData(200, 263, 10, 10);
        hp = 5;
        speed = 6;
        score = 400;
        Type =4;
    }

    @Override
    public void Update(long GameTime){
        super.Update(GameTime);

        m_BoundBox.set(m_x,m_y,m_x+150,m_y+123);
    }

}
