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

public class ContactFragment extends Fragment {
    private LinearLayout rowHolder;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public  ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance(){
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        rowHolder = (LinearLayout) view.findViewById(R.id.contactFragmentRowHolder);
        setupRows();
        return view;
    }
    private void setupRows() {


        PhoneItem phoneItem = new PhoneItem();
        CvRow cellPhoneRow = new CvRow(getActivity(), phoneItem);

        MailItem mailItem = new MailItem("email me", R.drawable.ic_mail_outline_black_24dp);
        CvRow emailRow = new CvRow(getActivity(), mailItem);

        WebItem gitHubItem = new WebItem("gitHub", R.drawable.ic_github_24dp, "http://github.com/kasper320");
        CvRow gitHubRow = new CvRow(getActivity(), gitHubItem);

        WebItem webItemLinkedIn = new WebItem("linkedIn", R.drawable.linkedin_24dp, "http://linkedin.com");
        CvRow linkedInRow = new CvRow(getActivity(), webItemLinkedIn);

        WebItem addressItem = new WebItem("address", R.drawable.address, "http://www.google.pl/maps/place/Marka+H%C5%82aski+46,+Wroc%C5%82aw/@51.1003489,16.9488968");
        CvRow addressRow = new CvRow(getActivity(), addressItem);

        CvRow[] cvRows = new CvRow[]{cellPhoneRow, emailRow, gitHubRow, linkedInRow, addressRow};

        for (int i = 0; i < cvRows.length; i++) {
            rowHolder.addView(cvRows[i]);

        }
    }
}

