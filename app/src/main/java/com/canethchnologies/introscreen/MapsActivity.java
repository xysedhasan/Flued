package com.canethchnologies.introscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    AppCompatButton schedule;
    DrawerLayout dl;
    ActionBarDrawerToggle t;
    NavigationView nv;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        toolbar = (Toolbar) findViewById(R.id.tool);
        navigation();



        schedule = findViewById(R.id.schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style));

            if (!success) {

            }
        } catch (Resources.NotFoundException e) {

        }
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void Close(View V) {
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        dl.closeDrawers();
    }


    public void navigation() {

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);


        getSupportFragmentManager();
        //setSupportActionBar(toolbar);
        t = new ActionBarDrawerToggle(this, dl, toolbar, R.string.Open, R.string.Close);
        //toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.bar));

        dl.addDrawerListener(t);
        t.syncState();

       // getSupportActionBar().setHomeButtonEnabled(true);


        nv = (NavigationView) findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.home: {

                        Intent intent = new Intent(MapsActivity.this, MapsActivity.class);
                        startActivity(intent);
                    }
                    break;

                    case R.id.profile: {

                        Intent intent = new Intent(MapsActivity.this, ProfileActivity.class);
                        startActivity(intent);
                    }
                    break;

                    case R.id.paymentmethods: {

                        Intent intent = new Intent(MapsActivity.this, PaymentInfoActivity.class);
                        startActivity(intent);
                    }
                    break;


                    case R.id.scheduledeliveries: {
                        Intent intent;
                        intent = new Intent(MapsActivity.this, ScheduleActivity.class);
                        startActivity(intent);
                    }
                    break;

                    case R.id.pastorders: {
                        Intent intent;
                        intent = new Intent(MapsActivity.this, PastOrdersActivity.class);
                        startActivity(intent);
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

                        Intent intent = new Intent(MapsActivity.this, LoginActivity.class);
                        startActivity(intent);
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