package org.Game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;

/**
 * Created by SeungHyun on 2017-06-21.
 */

public class Timer extends GraphicObject {

    public static final int GAME_PLAY = 0;
    public static final int GAME_END = 1;

    public int GamePlayState;

    public  long GamePlayTime;

    private Bitmap TimerNumber;
    private int TimerNumberWidth;
    private Bitmap TimerColon;
    private Rect TimerMinuteDrawRect;
    private Rect TimerTenSecondDrawRect;
    private Rect TimerOenSecondDrawRect;

    public Timer() {
        super(AppManager.getInstance().getBitmap(R.drawable.item_timer));
        this.TimerNumber = AppManager.getInstance().getBitmap(R.drawable.item_timer_number);
        this.TimerColon = AppManager.getInstance().getBitmap(R.drawable.item_timer_colon);
        this.GamePlayTime = System.currentTimeMillis();
        SetPosition(500, 10);
        TimerNumberWidth = 40;
        this.TimerMinuteDrawRect = new Rect(0, 0, TimerNumberWidth ,60);
        this.TimerTenSecondDrawRect = new Rect(0, 0, TimerNumberWidth ,60);
        this.TimerOenSecondDrawRect = new Rect(0, 0, TimerNumberWidth ,60);
        this.GamePlayState = Timer.GAME_PLAY;
    }


    @Override
    public void Draw(Canvas canvas) {
        Rect DrawTimerMinuteBox = new Rect(650, 30, 700, 76);
        Rect DrawTimerTenSecondBox = new Rect(750, 30, 800, 76);
        Rect DrawTimerOneSecondBox = new Rect(800, 30, 850, 76);
        canvas.drawBitmap(this.TimerColon, 700, 30, null);
        canvas.drawBitmap(this.TimerNumber, this.TimerMinuteDrawRect, DrawTimerMinuteBox, null);
        canvas.drawBitmap(this.TimerNumber, this.TimerTenSecondDrawRect, DrawTimerTenSecondBox, null);
        canvas.drawBitmap(this.TimerNumber, this.TimerOenSecondDrawRect, DrawTimerOneSecondBox, null);
        super.Draw(canvas);
    }

    @Override
    public void Update(long GameTime) {
        long GamePlayTimeMinute = 1 - (System.currentTimeMillis() - this.GamePlayTime)/ (1000 * 60);
        long GamePlayTimeSecond = 59 - ((System.currentTimeMillis() - this.GamePlayTime)/ 1000) % 60;

        this.TimerMinuteDrawRect.left = (int)(GamePlayTimeMinute * TimerNumberWidth);
        this.TimerMinuteDrawRect.right = this.TimerMinuteDrawRect.left + TimerNumberWidth;
        this.TimerTenSecondDrawRect.left = (int)(GamePlayTimeSecond/10 * TimerNumberWidth);
        this.TimerTenSecondDrawRect.right = this.TimerTenSecondDrawRect.left + TimerNumberWidth;
        this.TimerOenSecondDrawRect.left = (int)(GamePlayTimeSecond%10 * TimerNumberWidth);
        this.TimerOenSecondDrawRect.right = this.TimerOenSecondDrawRect.left + TimerNumberWidth;

        if(GamePlayTimeMinute == 0 && GamePlayTimeSecond == 0)
            this.GamePlayState = Timer.GAME_END;
        super.Update(GameTime);
    }
}
