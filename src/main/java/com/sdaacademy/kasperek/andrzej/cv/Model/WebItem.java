package com.sdaacademy.kasperek.andrzej.cv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by RENT on 2017-04-05.
 */

public class WebItem extends CvItem {
    private Uri uri;

    public WebItem(String text, int icon, String url) {
        super(text, icon);
        uri = Uri.parse(url);
    }

    @Override
    public void performAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        context.startActivity(intent);
    }
}
