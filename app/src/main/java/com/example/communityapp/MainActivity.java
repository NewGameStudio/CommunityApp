package com.example.communityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Master.NavigationMaster;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static MainActivity activity;

    public static MainActivity getMainActivity() {
        return activity;
    }


    protected void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    protected void configureBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_fragment);

        NavigationUI.setupWithNavController(bottomNav, navHostFragment.getNavController());
    }

    protected void configureBackground() {
        RelativeLayout layout = findViewById(R.id.main_activity_layout);
        AnimationDrawable drawable = (AnimationDrawable) layout.getBackground();
        drawable.setEnterFadeDuration(2000);
        drawable.setExitFadeDuration(4000);
        drawable.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureToolbar();
        configureBottomNavigation();
        configureBackground();

        activity = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.logout_btn:
                UserController.logout();
                NavigationMaster.navigate(findViewById(R.id.content_fragment),
                        R.id.action_global_signInFragment);
                return true;

            default:
                return false;
        }
    }
}