package com.example.communityapp.Controllers;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

public class UserController {

    public static boolean login(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

    public static void logout() {

    }


    public static Bitmap getAvatarImage() {
        Activity activity = MainActivity.getMainActivity();
        return BitmapFactory.decodeResource(activity.getResources(), R.drawable.wolf);
    }

    public static String getName() {
        return "Дима Шелохвостов";
    }

    public static String getProfileDescription() {
        return "Прошу вас запомнить сразу, что я не кальянщик.\nНенавижу неточности";
    }
}
