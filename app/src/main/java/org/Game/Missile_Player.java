package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

public class Missile_Player extends Missile {
	public static final int STATE_NORMAL = 0;
	public static final int STATE_OUT = 1;

	public int state =  STATE_NORMAL;
	Missile_Player(int x,int y){
		super(AppManager.getInstance().getBitmap(R.drawable.wp_arrow_refair));
		this.SetPosition(x, y);
	}
	
	public void Update(){
		m_x +=20;
		if(m_x > 1920)
			state = STATE_OUT;

		m_BoundBox.left = m_x;
		m_BoundBox.top = m_y;
		m_BoundBox.right = m_x +50;
		m_BoundBox.bottom = m_y +30;
		
	}
}
