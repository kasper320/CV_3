package com.sdaacademy.kasperek.andrzej.cv.Views;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sdaacademy.kasperek.andrzej.cv.Model.CvItem;
import com.sdaacademy.kasperek.andrzej.cv.Model.WebItem;
import com.sdaacademy.kasperek.andrzej.cv.R;

/**
 * Created by RENT on 2017-04-04.
 */

public class CvRow extends LinearLayout {
    public CvRow(final Context context,final CvItem cvItem) {
        super(context);

        setupLayouts(context);
        TextView textField = setupTextView(context, cvItem);
        ImageView iconField = setupImageView(context, cvItem);
        addViews(textField, iconField);
        if (cvItem instanceof WebItem){
            WebItem webItem = (WebItem) cvItem;
            this.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    cvItem.performAction(context);
                }
            });
        }



    }

    private void setupLayouts(Context context) {
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) dpToPx(48, context)));
        this.setPadding(dpToPx(16,context), 0, dpToPx(16,context), 0);
        this.setOrientation(LinearLayout.HORIZONTAL);
    }

    private void addViews(TextView textField, ImageView iconField) {
        this.addView(iconField);
        this.addView(textField);
    }

    @NonNull
    private ImageView setupImageView(Context context, CvItem cvItem) {
        ImageView iconField = new ImageView(context);
        iconField.setImageResource(cvItem.getIcon());
        LayoutParams iconFieldParams = new LayoutParams(dpToPx(24,context), dpToPx(24,context));
        iconField.setLayoutParams(iconFieldParams);
        iconFieldParams.gravity=  Gravity.CENTER_VERTICAL;
        iconField.setBackgroundColor(getResources().getColor(R.color.divider));
        return iconField;
    }

    @NonNull
    private TextView setupTextView(Context context, CvItem cvItem) {
        TextView textField = new TextView(context);
        textField.setText(cvItem.getCaption());
        textField.setPadding(dpToPx(32,context), 0, dpToPx(32,context), 0);
        textField.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textField.setGravity(Gravity.CENTER_VERTICAL);
        textField.setTextSize(16);
        textField.setPadding(dpToPx(32,context),0,0,0);
        return textField;
    }

    public static int dpToPx(float dp, Context context){

        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);

        return (int)px;
    }


    public static float pxToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }


}
