package org.Game;

import android.graphics.Bitmap;

import org.Framework.GraphicObject;

/**
 * Created by KimYoung-Suh on 2017. 5. 16..
 */

public class Effect_Explosion extends GraphicObject {
    public static final int STATE_NORMAL = 0;
    public static final int STATE_DELETE = 1;
    long m_LastEnemyEffect = System.currentTimeMillis();
    public int state =  STATE_NORMAL;
    public Effect_Explosion(Bitmap bitmap) {
        super(bitmap);

    }
    void Delete(){
        if(System.currentTimeMillis() - m_LastEnemyEffect >= 1000){
            m_LastEnemyEffect = System.currentTimeMillis();
            state = STATE_DELETE;
        }
    }

    @Override
    public void Update(long GameTime) {
        super.Update(GameTime);
        Delete();
    }
}
