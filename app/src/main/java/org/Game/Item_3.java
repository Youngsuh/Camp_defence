package org.Game;

import android.content.ClipData;

import org.Framework.AppManager;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 5. 4..
 */

public class Item_3 extends Item {

    public Item_3(int x, int y) {
        super(AppManager.getInstance().getBitmap(R.drawable.item_speed_up));
        this.SetPosition(32, 32);
        m_x = x;
        m_y = y;
    }

    @Override
    public void Update(long GameTime) {
        super.Update(GameTime);
    }

}
