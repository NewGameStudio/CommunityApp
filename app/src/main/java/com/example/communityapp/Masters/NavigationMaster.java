package com.example.communityapp.Masters;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class NavigationMaster {

    public static void navigate(View view, int actionId) {

        NavController navController = Navigation.findNavController(view);
        navController.navigate(actionId);
    }
}
