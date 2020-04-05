package com.destructo.corona_tracker.View.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.destructo.corona_tracker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            //Added this if statement to keep the selected fragment when rotating the device
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                        new FragmentGlobal()).commit();
                setTitle("Global Statistics");

            }

            navigation = findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);

                navigation.getMenu().getItem(0).setIcon(R.drawable.ic_global_normal);
                navigation.getMenu().getItem(1).setIcon(R.drawable.ic_india_two_normal);
                navigation.getMenu().getItem(2).setIcon(R.drawable.ic_map_normal);
                navigation.getMenu().getItem(3).setIcon(R.drawable.ic_safety_normal);
                navigation.getMenu().getItem(4).setIcon(R.drawable.ic_about_normal);

                switch (item.getItemId()) {
                    case R.id.navigation_global:
                        item.setIcon(R.drawable.ic_global_pressed);
                        setTitle(R.string.title_global);
                        if (!(currentFragment instanceof FragmentGlobal)) {
                        fragment = new FragmentGlobal();
                        loadFragment(fragment);
                        }
                        return true;

                    case R.id.navigation_india:
                        item.setIcon(R.drawable.ic_india_two_normal);
                        setTitle(R.string.title_india_stats);
                        if (!(currentFragment instanceof FragmentIndia)) {
                            fragment = new FragmentIndia();
                            loadFragment(fragment);
                        }
                        return true;

                    case R.id.navigation_live_map:
                        item.setIcon(R.drawable.ic_map_pressed);
                        setTitle(R.string.title_live_map);
                        if (!(currentFragment instanceof FragmentLiveMap)) {
                            fragment = new FragmentLiveMap();
                            loadFragment(fragment);
                        }
                        return true;

                    case R.id.navigation_help:
                        item.setIcon(R.drawable.ic_safety_new_pressed);
                        setTitle(R.string.title_help);
                        if (!(currentFragment instanceof FragmentHelp)) {
                            fragment = new FragmentHelp();
                            loadFragment(fragment);
                        }
                        return true;

                    case R.id.navigation_settings:
                        item.setIcon(R.drawable.ic_about_pressed);
                        setTitle(R.string.title_about);
                        if (!(currentFragment instanceof FragmentAbout)) {
                            fragment = new FragmentAbout();
                            loadFragment(fragment);
                        }
                        return true;

                }
                return false;
            }
        };


        private void loadFragment (Fragment newFragment){

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, newFragment);
                transaction.commit();

        }
    @Override public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
        if (!(fragment instanceof HandleBackPress) || !((HandleBackPress) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }
}






