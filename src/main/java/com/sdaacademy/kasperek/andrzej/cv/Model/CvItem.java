package com.sdaacademy.kasperek.andrzej.cv.Model;

import android.content.Context;

/**
 * Created by RENT on 2017-04-05.
 */

public abstract class CvItem {
    String caption;
    int icon;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public CvItem(String caption, int icon) {
        this.caption = caption;
        this.icon = icon;
    }
    public abstract void performAction(Context context);
}
