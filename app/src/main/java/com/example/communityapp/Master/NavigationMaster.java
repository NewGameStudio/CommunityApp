package com.example.communityapp.Master;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.communityapp.Entities.FreelanceTask;

public class NavigationMaster {

    private static FreelanceTask currentFreelanceTask;

    public static void navigate(View view, int actionId) {

        NavController navController = Navigation.findNavController(view);
        navController.navigate(actionId);
    }
}
