package com.sdaacademy.kasperek.andrzej.cv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sdaacademy.kasperek.andrzej.cv.Model.MailItem;
import com.sdaacademy.kasperek.andrzej.cv.Model.PhoneItem;
import com.sdaacademy.kasperek.andrzej.cv.Model.WebItem;
import com.sdaacademy.kasperek.andrzej.cv.Views.CvRow;


public class SkillsFragment extends Fragment {
    private LinearLayout rowHolder;
    public  SkillsFragment() {
        // Required empty public constructor
    }
    public static SkillsFragment newInstance() {
        SkillsFragment fragment = new SkillsFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        rowHolder = (LinearLayout) view.findViewById(R.id.skillsFragmentRowHolder);
        setupRows();
        return view;

    }

    private void setupRows() {



        MailItem mailItem = new MailItem("email me", R.drawable.ic_mail_outline_black_24dp);
        CvRow emailRow = new CvRow(getActivity(), mailItem);


        CvRow[] cvRows = new CvRow[]{emailRow, };

        for (int i = 0; i < cvRows.length; i++) {
            rowHolder.addView(cvRows[i]);

        }
    }
}
