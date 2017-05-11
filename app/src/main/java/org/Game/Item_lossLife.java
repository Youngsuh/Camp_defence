package org.Game;

import android.content.ClipData;

import org.Framework.AppManager;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 5. 4..
 */

public class Item_lossLife extends Item {

    public Item_lossLife(int x,int y) {
        super(AppManager.getInstance().getBitmap(R.drawable.item1));

        m_x = x;
        m_y = y;
    }

    @Override
    void GetItem(){


    }

}
