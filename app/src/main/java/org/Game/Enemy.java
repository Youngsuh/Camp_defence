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
	


	protected int hp;
	protected float speed;
	protected int score;

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

		if(m_x < 0)
			state = STATE_OUT;
		
	}

	
	@Override
	public void Update(long GameTime){
		super.Update(GameTime);
		Move();
	}
	
}
