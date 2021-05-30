package com.example.cryptocurrencytracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class botnavActivity extends AppCompatActivity {

    private BottomNavigationView botnav_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botnav);

        botnav_nav = findViewById(R.id.botnav_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.botnav_framelayout, new GraphFragment()).commit();

        setBottomNavbar();
    }

    private void setBottomNavbar() {
        botnav_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.menu_graph) {
                    selectedFragment = new GraphFragment();
                } else if (item.getItemId() == R.id.menu_price) {
                    selectedFragment = new PriceFragment();
                } else if (item.getItemId() == R.id.menu_profile) {
                    selectedFragment = new ProfileFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.botnav_framelayout, selectedFragment).commit();

                return true;
            }
        });
    }
}