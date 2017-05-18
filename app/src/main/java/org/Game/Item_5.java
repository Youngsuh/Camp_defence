package org.Game;

import org.Framework.AppManager;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 5. 4..
 */

public class Item_5 extends Item {

    public Item_5(int x, int y) {
        super(AppManager.getInstance().getBitmap(R.drawable.item_timer));
        this.SetPosition(32, 32);
        m_x = x;
        m_y = y;
    }

    @Override
    public void Update(long GameTime) {
        super.Update(GameTime);
    }

}
