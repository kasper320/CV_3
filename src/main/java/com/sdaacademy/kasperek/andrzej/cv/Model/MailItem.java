package com.sdaacademy.kasperek.andrzej.cv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by RENT on 2017-04-05.
 */

public class MailItem extends CvItem {

    public static final String emailAddress = "kasperek.andrzej@gmail.com";

    public MailItem(String caption, int icon) {
        super(caption, icon);
    }

    @Override
    public void performAction(Context context) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        intent.putExtra(Intent.EXTRA_SUBJECT, emailMessage());
        context.startActivity(intent);
    }

    @NonNull
    private String emailMessage() {
        return "Wiadomość z aplikacji CV";
    }
}

