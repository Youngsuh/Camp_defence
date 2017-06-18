package org.Game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;
import org.Framework.SpriteAnimation;

/**
 * Created by KimYoung-Suh on 2017. 6. 15..
 */

public class UI_ScoreBoard extends GraphicObject {

    public int m_life;
    public int m_left = 30;
    public int m_top = 12;
    public int m_right = 20;
    public int m_bottom = 40;
    public UI_ScoreBoard() {
        super(AppManager.getInstance().getBitmap(R.drawable.pl_score_board));
        m_life = AppManager.getInstance().m_gamestate.m_life;
    }



    @Override
    public void Update(long GameTime) {
        Rect rc = new Rect(m_left, m_top, m_right * m_life,m_bottom);
        m_life = AppManager.getInstance().m_gamestate.m_life;

    }
    @Override
    public void Draw(Canvas canvas){
        Rect rc = new Rect(m_left, m_top, m_right* m_life, m_bottom);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawBitmap(m_bitmap,10,10,null);
        canvas.drawRect(rc,paint );
    }
}
