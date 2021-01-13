package com.canethchnologies.introscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout dl;
    ActionBarDrawerToggle t;
    NavigationView nv;
    Toolbar toolbar;
    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.tool);
        navigation();
    }


    public void Close(View V) {
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        dl.closeDrawers();
    }


    public void navigation() {

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);


        //setSupportActionBar(toolbar);
        t = new ActionBarDrawerToggle(this, dl, toolbar, R.string.Open, R.string.Close);
        //toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.bar));

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);


        nv = (NavigationView) findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.home: {

                    }
                    break;

                    case R.id.profile: {

                    }
                    break;

                    case R.id.paymentmethods: {

                    }
                    break;


                    case R.id.scheduledeliveries: {

                    }
                    break;

                    case R.id.pastorders: {
                        Intent intent;
                      /*  intent = new Intent(DashboardActivity.this, Help.class);
                        startActivity(intent);*/
                    }
                    break;

                    case R.id.tellyourfriend: {

                    }
                    break;

                    case R.id.rateapp: {

                    }
                    break;
                    case R.id.help: {

                    }
                    break;
                    case R.id.logout: {

                    }
                    break;

                    default:
                        return true;
                }

                return true;
            }

        });
    }
}