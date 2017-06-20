package org.Game;

import org.Framework.AppManager;
import org.Framework.SpriteAnimation;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Enemy extends SpriteAnimation {

	public static final int STATE_NORMAL = 0;
	public static final int STATE_OUT = 1;
	
	public int state =  STATE_NORMAL;

	Rect m_BoundBox = new Rect();


	public Player m_player;
	protected int hp;
	public float speed;
	public int score;

	public int Type;
	public Enemy(Bitmap bitmap) {
		super(bitmap);
	}
	public void Damage(int damage){
		hp -= damage; 
	}
	public int GetHP(){
		return hp;
	}
	
	void Move(){
		// 움직이는 로직
		m_x -= speed;

		if(m_x < 0){
			state = STATE_OUT;
			//해결해야 할 사항1 - 이곳에 m_player.getLife() -- 가 들어가야함
			if(Type != 5)
			AppManager.getInstance().m_gamestate.m_life--;
		}
		
	}

	
	@Override
	public void Update(long GameTime){
		super.Update(GameTime);
		Move();
	}
	
}
