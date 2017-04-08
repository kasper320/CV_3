package com.sdaacademy.kasperek.andrzej.cv;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sdaacademy.kasperek.andrzej.cv.Model.MailItem;
import com.sdaacademy.kasperek.andrzej.cv.Model.PhoneItem;
import com.sdaacademy.kasperek.andrzej.cv.Model.WebItem;
import com.sdaacademy.kasperek.andrzej.cv.Views.CvRow;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.mainActivityNavigationView)
    NavigationView navigationView;
    @BindView(R.id.mainActivityContainer)
    FrameLayout container;
    @BindView(R.id.mainActivityToolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().performIdentifierAction(R.id.navigationMenuContact,0);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

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
        drawerLayout.closeDrawer(Gravity.LEFT);
        toolbar.setTitle(item.getTitle());
        unCheckMenuItems(item);
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigationMenuContact:
                fragment=ContactFragment.newInstance();
                break;
            case R.id.navigationMenuUmiejetnosci:
               fragment = SkillsFragment.newInstance();
                break;
            case R.id.ViewMenuForm:
                fragment=FormFragment.newInstance();
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.mainActivityContainer, fragment).commit();
        return false;
    }

    private void unCheckMenuItems(@NonNull MenuItem item) {
        for (int i = 0; i < navigationView.getMenu().size(); i++) {
            if (navigationView.getMenu().getItem(i).isChecked()) {
                navigationView.getMenu().getItem(i).setChecked(false);
            }
            item.setChecked(true);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mainActivityMenuSettings:
                InfoFragment.newInstance().show(getSupportFragmentManager(),"");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
