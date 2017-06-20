package org.Game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 6. 8..
 */

public class BackGround_GameOver extends GraphicObject{
    public BackGround_GameOver() {
        super(AppManager.getInstance().getBitmap(R.drawable.bg_ending_background));
    }

    @Override
    public void Update(long GameTime) {
    }

    @Override
    public void Draw(Canvas canvas){
        Bitmap m_bitmap_scale = Bitmap.createScaledBitmap(m_bitmap, AppManager.getInstance().getGameView().getWidth(),
                AppManager.getInstance().getGameView().getHeight(), true);
        canvas.drawBitmap(m_bitmap_scale,m_x,m_y,null);
    }
}
