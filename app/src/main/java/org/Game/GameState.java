package org.Game;

import java.util.ArrayList;
import java.util.Random;

import org.Framework.AppManager;
import org.Framework.Collision;
import org.Framework.CollisionManager;
import org.Framework.IState;
import org.Framework.R;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class GameState implements IState {
	
	private long m_LastShoot = System.currentTimeMillis();
	private Player m_player;
	private Player_1 m_player_1;
	private Player_2 m_player_2;
	private Player_3 m_player_3;


	private BackGround m_background;

	//ArrayList<Players> m_plist = new ArrayList<Players>();
	ArrayList<Missile> m_pmslist = new ArrayList<Missile>();
	ArrayList<Missile> m_enemmslist = new ArrayList<Missile>();
	ArrayList<Item> m_itemlist = new ArrayList<Item>();
	ArrayList<Enemy> m_enemlist = new ArrayList<Enemy>();
	ArrayList<Effect_Explosion_1> m_explist = new ArrayList<Effect_Explosion_1>();
	
	private int m_scroll = 0;
	private final static int SCROLL_SPEED = 1;
	
	public int m_score = 0;
	
	long m_LastRegenEnemy = System.currentTimeMillis();
	
	Random m_randEnem = new Random();
	Random m_randItem = new Random();

	public Player GetPlayer(){
		return m_player;
	}

	public GameState(){
		AppManager.getInstance().m_gamestate = this;
	}
	
	public void CreateItem(int x , int y){
		int rand = m_randItem.nextInt(6);
		
		if(rand ==1)
			m_itemlist.add(new Item_AddLife(x,y));
		else if(rand ==2)
			m_itemlist.add(new Item_AddScore(x,y));
		else if(rand ==3)
			m_itemlist.add(new Item_lossLife(x,y));

	}
	@Override
	public void Init() {
        m_player = new Player(AppManager.getInstance().getBitmap(R.drawable.ballista));
		m_player_1 = new Player_1(AppManager.getInstance().getBitmap(R.drawable.ballista));
		m_player_2 = new Player_2(AppManager.getInstance().getBitmap(R.drawable.ballista));
		m_player_3 = new Player_3(AppManager.getInstance().getBitmap(R.drawable.ballista));

		m_background=new BackGround(1);
	}
	
	public void CheckCollision(){
		for (int i = m_pmslist.size()-1; i >= 0; i--) {
			for (int j = m_enemlist.size()-1; j >= 0; j--) {
	    		if(CollisionManager.CheckBoxToBox(m_pmslist.get(i).m_BoundBox,m_enemlist.get(j).m_BoundBox)){
	    			m_explist.add(new Effect_Explosion_1(m_enemlist.get(j).GetX(),m_enemlist.get(j).GetY()));
	    			CreateItem(m_enemlist.get(j).GetX(),m_enemlist.get(j).GetY());

	    			m_pmslist.remove(i);

	    			m_enemlist.get(j).Damage(m_player.GetPower());


					if(m_enemlist.get(j).GetHP() <= 0)
	    				m_enemlist.remove(j);

	    			return;
	    		}
	        }
        }

		for (int i = m_enemlist.size()-1; i >= 0; i--) {
    		if(CollisionManager.CheckBoxToBox(m_player.m_BoundBox,m_enemlist.get(i).m_BoundBox)){

				//여기 바꿔야함
    			m_explist.add(new Effect_Explosion_1(m_enemlist.get(i).GetX(),m_enemlist.get(i).GetY()));

				m_enemlist.remove(i);
 //   			m_player.destroyPlayer();
    			if(m_player.getLife() == 0 )
    				System.exit(0);
    		}
        }

		for (int i = m_enemmslist.size()-1; i >= 0; i--) {
    		if(CollisionManager.CheckBoxToBox(m_player.m_BoundBox,m_enemmslist.get(i).m_BoundBox)) {
				m_enemmslist.remove(i);

//    			m_player.destroyPlayer();
				if (m_player.getLife() <= 0) {
					m_player.destroyPlayer();
				}
			}

        }
	//	for (int i = m_itemlist.size()-1; i >= 0; i--) {
   // 		if(CollisionManager.CheckBoxToBox(m_player_1.m_BoundBox,m_itemlist.get(i).m_BoundBox)){
    //			m_itemlist.get(i).GetItem();
    //			m_itemlist.remove(i);
   // 		}
	//
	//		return;
    //    }

	}

	public void MakeEnemy(){
				
		if(System.currentTimeMillis() - m_LastRegenEnemy >= 1000 ){
			m_LastRegenEnemy = System.currentTimeMillis();
			
			int enemtype = m_randEnem.nextInt(4);
			int enemPosi = m_randEnem.nextInt(4);
			Enemy enem = null;
			if(enemtype == 0){
				enem = new Enemy_1();
			}
			else if(enemtype == 1){
				enem = new Enemy_2();
			}
			else if(enemtype == 2){
				enem = new Enemy_3();
			}
			else if(enemtype == 3){
				enem = new Enemy_4();
			}
			if(enemPosi == 0) {
				enem.SetPosition(1920, 200);
			}
			if(enemPosi == 1) {
				enem.SetPosition(1920, 400);
			}
			if(enemPosi == 2) {
				enem.SetPosition(1920, 600);
			}
			if(enemPosi == 3) {
				enem.SetPosition(1920, 800);
			}
			m_enemlist.add(enem);
		}
			
	}
	
	
	@Override
	public void Render(Canvas canvas) {
    	m_background.Draw(canvas);
    	for (Missile pms : m_pmslist) {
    		pms.Draw(canvas);
        }
    	for (Missile enemms : m_enemmslist) {
    		enemms.Draw(canvas);
        }
    	for (Enemy enem : m_enemlist) {
    		enem.Draw(canvas);
        }
    	for (Effect_Explosion_1 exp : m_explist) {
    		exp.Draw(canvas);
        }

    	for (Item item : m_itemlist) {
    		item.Draw(canvas);
        }

		m_player.Draw(canvas);
		m_player_1.Draw(canvas);
		m_player_2.Draw(canvas);
		m_player_3.Draw(canvas);

		Paint p = new Paint();
    	p.setTextSize(20); p.setColor(Color.BLACK); 
    	canvas.drawText("Life :"+String.valueOf(m_player.getLife()),0,20,p);
    	canvas.drawText("Score :"+String.valueOf(m_score),0,40,p);
	}


    @Override
    public void Update() {
        long GameTime = System.currentTimeMillis();
        m_background.Update(GameTime);

        for (int i = m_pmslist.size()-1; i >= 0; i--) {
            Missile pms = m_pmslist.get(i);
            pms.Update();
            if(pms.state == Missile.STATE_OUT){
                m_pmslist.remove(i);
            }
        }
        for (int i = m_enemmslist.size()-1; i >= 0; i--) {
            Missile enemms = m_enemmslist.get(i);
            enemms.Update();
            if(enemms.state == Missile.STATE_OUT){
                m_enemmslist.remove(i);
            }
        }
        for (int i = m_enemlist.size()-1; i >= 0; i--) {
            Enemy enem = m_enemlist.get(i);
            enem.Update(GameTime);
            if(enem.state == Enemy.STATE_OUT)
                m_enemlist.remove(i);
        }

        for (int i = m_itemlist.size()-1; i >= 0; i--) {
            Item item = m_itemlist.get(i);
            item.Update(GameTime);
        }
        MakeEnemy();
        CheckCollision();
    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		return true;
	}


	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		

		for(int i =0; i<event.getPointerCount();i++){
			int _x = (int) event.getX(i);
			int _y = (int) event.getY(i);
			if(Collision.CollisionCheckPointToBox(_x,_y, 100, 100, 300, 300)){
				m_pmslist.add(new Missile_Player(_x+10,200));
			}
			if(Collision.CollisionCheckPointToBox(_x,_y, 100, 300, 300, 500)){
				m_pmslist.add(new Missile_Player(_x+10,400));
			}
			if(Collision.CollisionCheckPointToBox(_x,_y, 100, 500, 300, 700)){
				m_pmslist.add(new Missile_Player(_x+10,600));
			}
			if(Collision.CollisionCheckPointToBox(_x,_y, 100, 700, 300, 900)){
				m_pmslist.add(new Missile_Player(_x+10,800));
			}

			
		}
		return true;
	}

	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		
	}

}
