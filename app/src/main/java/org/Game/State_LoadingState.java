package org.Game;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import org.Framework.AppManager;
import org.Framework.IState;
import org.Framework.R;
import org.Framework.SoundManager;

/**
 * Created by KimYoung-Suh on 2017. 6. 8..
 */
//로딩페이지
public class State_LoadingState implements IState {

    public State_LoadingState() {
        AppManager.getInstance().m_loadingstate = this;
    }

    long Timer = System.currentTimeMillis();


    private BackGround_loading m_loading_background;

    public static final int SOUND_EFFECT_1 = 1; // bg



    @Override
    public void Init() {

        SoundManager.getInstance().Init(AppManager.getInstance().getActivity());
       // SoundManager.getInstance().addSound(SOUND_EFFECT_1, R.raw.sound_main_stage);
        SoundManager.getInstance().MakeMedia(R.raw.sound_launch);
        m_loading_background = new BackGround_loading();

    }

    @Override
    public void Destroy() {

    }

    @Override
    public void Update() {
        if (System.currentTimeMillis() - Timer >= 2000) {
            SoundManager.getInstance().play_Media();
            AppManager.getInstance().getGameView().ChangeGameState(new State_StartState());
        }
    }

    @Override
    public void Render(Canvas canvas) {
        m_loading_background.Draw(canvas);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return false;
    }


}
