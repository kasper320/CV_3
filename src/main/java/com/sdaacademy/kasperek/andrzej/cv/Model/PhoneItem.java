package com.sdaacademy.kasperek.andrzej.cv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;

import com.sdaacademy.kasperek.andrzej.cv.Constants;
import com.sdaacademy.kasperek.andrzej.cv.R;

/**
 * Created by RENT on 2017-04-05.
 */

public class PhoneItem extends CvItem {
    private String phoneNumber = Constants.PHONE_NUMBER;
    private Uri uri;

    public PhoneItem() {
        super(Constants.PHONE_NUMBER, R.drawable.ic_phone_black_24dp);
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
