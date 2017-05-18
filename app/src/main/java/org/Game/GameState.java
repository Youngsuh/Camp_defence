package org.Game;

import java.util.ArrayList;
import java.util.Random;

import org.Framework.AppManager;
import org.Framework.Collision;
import org.Framework.CollisionManager;
import org.Framework.IState;
import org.Framework.R;
import org.Framework.SoundManager;

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

	public static final int SOUND_EFFECT_1 = 1; // bg
	public static final int SOUND_EFFECT_2 = 2; //
	public static final int SOUND_EFFECT_3 = 3; //
	public static final int SOUND_EFFECT_4 = 4;	//
	public static final int SOUND_EFFECT_5 = 5;	//
	public static final int SOUND_EFFECT_6 = 6;	// em_1_ice wolf
	public static final int SOUND_EFFECT_7 = 7;	// em_2_ yeti
	public static final int SOUND_EFFECT_8 = 8;	// em_3_ bouns
	public static final int SOUND_EFFECT_9 = 9;	// em_4_ falcon

	public int SCORE = 0;
	private BackGround m_background;

	//ArrayList<Players> m_plist = new ArrayList<Players>();
	ArrayList<Missile_Player> m_pmslist = new ArrayList<Missile_Player>();
	ArrayList<Item> m_itemlist = new ArrayList<Item>();
	ArrayList<Enemy> m_enemlist = new ArrayList<Enemy>();
	ArrayList<Effect_Explosion> m_explist = new ArrayList<Effect_Explosion>();

	private int m_scroll = 0;
	private final static int SCROLL_SPEED = 1;
	
	public int m_score = 0;
	
	long m_LastRegenEnemy = System.currentTimeMillis();
	long m_LastEnemyEffect = System.currentTimeMillis();

	Random m_randEnem = new Random();
	Random m_randItem = new Random();

	public Player GetPlayer(){
		return m_player;
	}

	public GameState(){
		AppManager.getInstance().m_gamestate = this;
	}

	@Override
	public void Init() {
        m_player = new Player(AppManager.getInstance().getBitmap(R.drawable.pl_ballista));
		m_player_1 = new Player_1(AppManager.getInstance().getBitmap(R.drawable.pl_ballista));
		m_player_2 = new Player_2(AppManager.getInstance().getBitmap(R.drawable.pl_ballista));
		m_player_3 = new Player_3(AppManager.getInstance().getBitmap(R.drawable.pl_ballista));

        SoundManager.getInstance().Init(AppManager.getInstance().getActivity());
		SoundManager.getInstance().addSound(SOUND_EFFECT_1, R.raw.sound_main_stage);
		SoundManager.getInstance().addSound(SOUND_EFFECT_6, R.raw.sound_ice_wolf);
        SoundManager.getInstance().addSound(SOUND_EFFECT_7 , R.raw.yeti_sound);
        SoundManager.getInstance().addSound(SOUND_EFFECT_8, R.raw.sound_bonus);
        SoundManager.getInstance().addSound(SOUND_EFFECT_9 , R.raw.sound_falcon);

        SoundManager.getInstance().play(1);
		m_background=new BackGround(1);
	}
	
	public synchronized void CheckCollision(){
		Effect_Explosion explist = null;
		Item item_list = null;
		synchronized(this) {
			for (int i = m_pmslist.size() - 1; i >= 0; i--) {
				for (int j = m_enemlist.size() - 1; j >= 0; j--) {
					int itemlist = m_randItem.nextInt(10);
					synchronized(this) {
					if (CollisionManager.CheckBoxToBox(m_pmslist.get(i).m_BoundBox, m_enemlist.get(j).m_BoundBox)) {
						m_enemlist.get(j).Damage(m_player.GetPower());
						m_pmslist.remove(i);

						if (m_enemlist.get(j).GetHP() <= 0) {
							if (m_enemlist.get(j).Type == 1) {
								explist = new Effect_Explosion_1(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
							} else if (m_enemlist.get(j).Type == 2) {
								explist = new Effect_Explosion_2(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
							} else if (m_enemlist.get(j).Type == 3) {
								explist = new Effect_Explosion_3(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
							} else if (m_enemlist.get(j).Type == 4) {
								explist = new Effect_Explosion_4(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
							}
							m_explist.add(explist);


							if (itemlist == 1) {
								item_list = new Item_1(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
								m_itemlist.add(item_list);

							} else if (itemlist == 2) {
								item_list = new Item_2(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
								m_itemlist.add(item_list);

							} else if (itemlist == 3) {
								item_list = new Item_3(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
								m_itemlist.add(item_list);

							}
							else if (itemlist == 4) {
								item_list = new Item_4(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
								m_itemlist.add(item_list);

							}
							else if (itemlist == 5) {
								item_list = new Item_5(m_enemlist.get(j).GetX(), m_enemlist.get(j).GetY());
								m_itemlist.add(item_list);

							}

							m_enemlist.remove(j);
							return;
						}
					}
					}
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
				
		if(System.currentTimeMillis() - m_LastRegenEnemy >= 1500 ){
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

    	for (Enemy enem : m_enemlist) {
    		enem.Draw(canvas);
        }
    	for (Effect_Explosion exp : m_explist) {
    		exp.Draw(canvas);
        }

   		for (Item item : m_itemlist) {
			item.Draw(canvas);
   	    }
		for (Missile_Player pms : m_pmslist) {

			pms.Draw(canvas);
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
			Missile_Player pms = m_pmslist.get(i);
            pms.Update();
            if(pms.state == Missile_Player.STATE_OUT){
                m_pmslist.remove(i);
            }
        }

        for (int i = m_enemlist.size()-1; i >= 0; i--) {
            Enemy enem = m_enemlist.get(i);
            enem.Update(GameTime);
            if(enem.state == Enemy.STATE_OUT)
                m_enemlist.remove(i);
        }
		for (int i = m_explist.size()-1; i >= 0; i--) {
			Effect_Explosion exp = m_explist.get(i);
			exp.Update(GameTime);
			if(exp.state == Effect_Explosion.STATE_DELETE){
				m_explist.remove(i);
			}
		}
        for (int i = m_itemlist.size()-1; i >= 0; i--) {
            Item item = m_itemlist.get(i);
            item.Update(GameTime);
			if(item.state == Item.STATE_DELETE){
				m_itemlist.remove(i);
			}
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



		int _x = (int) event.getX();
		int _y = (int) event.getY();

			if (Collision.CollisionCheckPointToBox(_x, _y, 100, 100, 300, 300)) {
				synchronized (this) {
					m_pmslist.add(new Missile_Player(_x + 10, 200));
				}
			} else if (Collision.CollisionCheckPointToBox(_x, _y, 100, 300, 300, 500)) {
				synchronized (this) {
					m_pmslist.add(new Missile_Player(_x + 10, 400));
				}
			} else if (Collision.CollisionCheckPointToBox(_x, _y, 100, 500, 300, 700)) {
				synchronized (this) {
					m_pmslist.add(new Missile_Player(_x + 10, 600));
				}
			} else if (Collision.CollisionCheckPointToBox(_x, _y, 100, 700, 300, 900)) {
				synchronized (this) {
					m_pmslist.add(new Missile_Player(_x + 10, 800));
				}
			}

		return true;
	}

	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		
	}

}
