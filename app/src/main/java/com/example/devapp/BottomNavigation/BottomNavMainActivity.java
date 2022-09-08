package com.example.devapp.BottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.devapp.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavMainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private BottomNavHomeFragment homeFragment = new BottomNavHomeFragment();
    private BottomNavNotifsFragment notifsFragment = new BottomNavNotifsFragment();
    private BottomNavSettingFragment settingsFragment = new BottomNavSettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottomnav);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_container, homeFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.bottom_nav_notifs);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(9);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_container, homeFragment).commit();
                        return true;
                    case R.id.bottom_nav_notifs:
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_container, notifsFragment).commit();
                        return true;
                    case R.id.bottom_nav_settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_container, settingsFragment).commit();
                        return true;
                }

                return false;
            }
        });
    }
}