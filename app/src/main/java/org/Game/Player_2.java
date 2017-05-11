package org.Game;

import android.graphics.Bitmap;
import android.graphics.Rect;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 5. 4..
 */

public class Player_2 extends GraphicObject {
    int m_Life = 5;
    int m_power = 3;
    Rect m_BoundBox = new Rect();
    public Player_2(Bitmap bitmap){
        super(bitmap);
        this.SetPosition(100, 500);
        m_BoundBox.set(m_x,m_y,m_x+100,m_y+100);

    }
    public int GetPower(){
        return m_power;
    }
    public void SetPower(int _power){
        m_power = _power;
    }



    public int getLife(){
        return m_Life;
    }
    public int lossLife() { return m_Life--;}
    public void destroyPlayer(){
        m_Life--;
    }
    public void AddLife(){
        m_Life++;
    }
}
