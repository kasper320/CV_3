package com.sdaacademy.kasperek.andrzej.cv;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sdaacademy.kasperek.andrzej.cv.Model.MailItem;
import com.sdaacademy.kasperek.andrzej.cv.Model.PhoneItem;
import com.sdaacademy.kasperek.andrzej.cv.Model.WebItem;
import com.sdaacademy.kasperek.andrzej.cv.Views.CvRow;

import butterknife.BindView;
import butterknife.ButterKnife;

//import static com.sdaacademy.kasperek.andrzej.cv.R.id.mainActivityAddressView;
//import static com.sdaacademy.kasperek.andrzej.cv.R.id.mainActivityEmailView;
//import static com.sdaacademy.kasperek.andrzej.cv.R.id.mainActivityPhoneView;
//import static com.sdaacademy.kasperek.andrzej.cv.R.id.mainActivitySkypeView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.mainActivityNavigationView)
    NavigationView navigationView;
    @BindView(R.id.mainActivityRowHolder)
    LinearLayout rowHolder;
    @BindView(R.id.mainActivityToolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(this);


//        View phoneView = findViewById(mainActivityPhoneView);
//        phoneView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialNumber();
//            }
//        });
//        View emailView = findViewById(mainActivityEmailView);
//        emailView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendEmail();
//
//            }
//        });
//
//        View skypeView = findViewById(mainActivitySkypeView);
//        skypeView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        View mailView = findViewById(mainActivityAddressView);
//        mailView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewIntent("http://www.google.pl/maps/place/Marka+H%C5%82aski+46,+Wroc%C5%82aw/@51.1003489,16.9488968", Intent.ACTION_VIEW);
//
//            }
//        });
//        View gitHubView = findViewById(R.id.mainActivityGitHuBView);
//        gitHubView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewIntent("https://github.com/kasper320",Intent.ACTION_VIEW);
//            }
//        });
        //LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mainActivityRowHolder);
        PhoneItem phoneItem = new PhoneItem("call me", R.drawable.ic_phone_black_24dp);
        CvRow cellPhoneRow = new CvRow(this, phoneItem);

        MailItem mailItem = new MailItem("email me", R.drawable.ic_mail_outline_black_24dp);
        CvRow emailRow = new CvRow(this, mailItem);

        WebItem gitHubItem = new WebItem("gitHub", R.drawable.ic_github_24dp, "http://github.com/kasper320");
        CvRow gitHubRow = new CvRow(this, gitHubItem);

        WebItem webItemLinkedIn = new WebItem("linkedIn", R.drawable.linkedin_24dp, "http://linkedin.com");
        CvRow linkedInRow = new CvRow(this, webItemLinkedIn);

        WebItem addressItem = new WebItem("address", R.drawable.address, "http://www.google.pl/maps/place/Marka+H%C5%82aski+46,+Wroc%C5%82aw/@51.1003489,16.9488968");
        CvRow addressRow = new CvRow(this, addressItem);

        //CvRow skypeRow = new CvRow(this, "skype", R.drawable.skype_24dp);

//
//        cellPhoneRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewIntent("tel:0048530480431", Intent.ACTION_DIAL);
//
//            }
//        });
//        emailRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewIntent("kasperek.adnrzej@gmail.com", Intent.ACTION_SENDTO);
//
//            }
//        });
//        addressRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewIntent("http://www.google.pl/maps/place/Marka+H%C5%82aski+46,+Wroc%C5%82aw/@51.1003489,16.9488968", Intent.ACTION_VIEW);
//
//            }
//        });
//        gitHubRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewIntent("http://github.com/kasper320", Intent.ACTION_VIEW);
//
//            }
//        });
////        skypeRow.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                startNewIntent("skype:andrzej_gls", Intent.ACTION_VIEW);
//
////            }
////        });
//        linkedInRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewIntent("skype:andrzej_gls", Intent.ACTION_VIEW);
//
//            }
//        });
        rowHolder.addView(cellPhoneRow);
        rowHolder.addView(emailRow);
        rowHolder.addView(addressRow);
//          linearLayout.addView(skypeRow);
        rowHolder.addView(linkedInRow);
        rowHolder.addView(gitHubRow);


    }

    private void openWebsite() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://github.com/kasper320"));
        startActivity(intent);
    }

    private void openMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.pl/maps/place/Marka+H%C5%82aski+46,+Wroc%C5%82aw/@51.1003489,16.9488968"));
        startActivity(intent);
    }

    private void dialNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0048530480431"));
        startActivity(intent);
    }

    private void startNewIntent(String uri, String action) {
        Intent intent = new Intent(action);
        intent.setData(Uri.parse(uri));
        startActivity(intent);

    }

    private void sendEmail() {
        Log.d(TAG, "MailViewClicked");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kasperek.andrzej@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Wiadomość z aplikacji CV");
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        toolbar.setTitle(item.getTitle());
        switch (item.getItemId()) {
            case R.id.navigationMenuContact:
                Toast.makeText(this, "Kontakt", Toast.LENGTH_SHORT).show();
                toolbar.setTitle(item.getTitle());
                break;
            case R.id.navigationMenuDoswiadczenie:
                Toast.makeText(this, "Doświadczenie", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationMenuMenuHobby:
                Toast.makeText(this, "Hobby", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationMenuUmiejetnosci:
                Toast.makeText(this, "Umiejętności", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationMenuWyksztalcenie:
                Toast.makeText(this, "Wykształcenie", Toast.LENGTH_SHORT).show();
                break;

        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
