package com.sdaacademy.kasperek.andrzej.cv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by RENT on 2017-04-05.
 */

public class PhoneItem extends CvItem {
    private String phoneNumber = "530483431";
    private Uri uri;

    public PhoneItem(String caption, int icon) {
        super(caption, icon);
       String number = "tel:" + phoneNumber;
        uri = Uri.parse(number);
    }

    @Override
    public void performAction(Context context) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        context.startActivity(intent);
    }
}
