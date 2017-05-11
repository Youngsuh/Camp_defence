package org.Framework;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;



public class GameActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
    	AppManager.getInstance().setActivity(this);
        setContentView(new GameView(this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        boolean retry = true;
        Thread _thread =  AppManager.getInstance().getThread();
        while (retry) {
            try {
                _thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }

    }
}