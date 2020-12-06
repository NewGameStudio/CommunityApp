package com.example.communityapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Master.NavigationMaster;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

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

    @SuppressLint("UseCompatLoadingForDrawables")
    protected void configureBackground(boolean gradient) {

        RelativeLayout layout = findViewById(R.id.main_activity_layout);

        if(gradient) {
            layout.setBackground(getDrawable(R.drawable.gradient_list));
            AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
            animationDrawable.setEnterFadeDuration(4000);
            animationDrawable.setExitFadeDuration(4000);
            animationDrawable.start();
        } else {
            layout.setBackgroundColor(Color.parseColor("#FAFAFA"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureToolbar();
        configureBottomNavigation();
        configureBackground(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.gradient_toggle:
                boolean checked = !item.isChecked();
                item.setChecked(checked);
                configureBackground(checked);
                return true;

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