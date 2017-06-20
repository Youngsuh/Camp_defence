package org.Framework;

import org.Game.State_GameOver;
import org.Game.State_GameState;
import org.Game.State_LoadingState;
import org.Game.State_StageClear;
import org.Game.State_StartState;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AppManager {

	// Main GameView
	private GameView m_gameview;
	// Main GameView 의 Resources
	private Resources m_resources;
	// Application 의 Activity
	private Activity m_activity;
	private Thread m_thread;


	// State_GameState
	public State_GameState m_gamestate;
	public State_LoadingState m_loadingstate;
	public State_StartState m_startstate;
	public State_GameOver m_gameover;
	public State_StageClear m_stateClear;
	private int m_width;
	private int m_height;

	public void setGameView(GameView _gameview) {
		m_gameview = _gameview;
	}

	public void setResources(Resources _resources) {
		m_resources = _resources;
	}

	public void setActivity(Activity _activity) {
		m_activity = _activity;
	}

	public void setThread(Thread _thread) {
		m_thread = _thread;
	}

	public Thread getThread() {
		return m_thread;
	}

	public GameView getGameView() {
		return m_gameview;
	}

	public Resources getResources() {
		return m_resources;
	}

	public Activity getActivity() {
		return m_activity;
	}

	public void setSize(int x, int y) {
		m_width = x;
		m_height = y;
	}

	public int getWidth() {
		return m_width;
	}

	public int getHeight() {
		return m_height;
	}

	public Bitmap getBitmap(int r) {
		return BitmapFactory.decodeResource(m_resources, r);
	}

	private static AppManager s_instance;

	public static AppManager getInstance() {
		if (s_instance == null) {
			s_instance = new AppManager();
		}
		return s_instance;
	}


}
