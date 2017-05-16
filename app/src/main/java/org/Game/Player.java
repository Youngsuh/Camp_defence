package org.Game;

import org.Framework.GraphicObject;
import org.Framework.R;
import org.Framework.SpriteAnimation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Player extends GraphicObject {


	Rect m_BoundBox = new Rect();

	int m_Life = 20;
	int m_power = 3;

	public Player(Bitmap bitmap) {
		super(bitmap);


		this.SetPosition(100, 100);
	}

	
	public int GetPower(){
		return m_power;
	}
	public void SetPower(int _power){
		m_power = _power;
	}

	private boolean bMove = false;
	private int _dirX = 0;
	private int _dirY = 0;
	
	public int getLife(){
		return m_Life;
	}
	public void destroyPlayer(){
		m_Life--;
	}
	public void AddLife(){
		m_Life++;
	}




}
