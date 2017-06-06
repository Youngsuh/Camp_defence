package org.Game;

import org.Framework.AppManager;
import org.Framework.GraphicObject;
import org.Framework.R;

/**
 * Created by KimYoung-Suh on 2017. 6. 1..
 */

public class Life extends GraphicObject {
    public Life(){
        super(AppManager.getInstance().getBitmap(R.drawable.pl_life));
        this.SetPosition(0,0);
    }

}

