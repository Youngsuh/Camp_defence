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
 * 6월 18일 현재상황
 *
 */

//게임 스타트를 할 수 있는 페이지
public class State_StartState implements IState {
    public State_StartState() {
        AppManager.getInstance().m_startstate = this;
    }


    private BackGround_startstate m_start_background;

    public static final int SOUND_EFFECT_1 = 1; // bg



    @Override
    public void Init() {
        //SoundManager.getInstance().Pause_Media();
        SoundManager.getInstance().Init(AppManager.getInstance().getActivity());
        // SoundManager.getInstance().addSound(SOUND_EFFECT_1, R.raw.sound_main_stage);
        SoundManager.getInstance().MakeMedia(R.raw.sound_main_stage);
        m_start_background = new BackGround_startstate();

    }

    @Override
    public void Destroy() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Render(Canvas canvas) {
        m_start_background.Draw(canvas);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SoundManager.getInstance().play_Media();
        AppManager.getInstance().getGameView().ChangeGameState(new State_GameState());
        return true;
    }

}
