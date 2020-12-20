package com.example.communityapp.Controllers;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.communityapp.Entities.UserEntity;
import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

import java.util.ArrayList;

public class UserController {

    private static UserEntity user;

    public static boolean login(String username, String password) {

        if(!username.equals("admin") || !password.equals("admin"))
            return false;

        user = new UserEntity();

        Activity activity = MainActivity.getMainActivity();
        Bitmap profileAvatar = BitmapFactory.decodeResource(activity.getResources(),
                R.drawable.blank_profile);

        user.setAvatar(profileAvatar);
        user.setUsername("Дима Шелохвостов");
        user.setDescription("Я мячик");

        return true;
    }

    public static void logout() {

    }


    public static Bitmap getAvatarImage() {
        return user.getAvatar();
    }

    public static String getUsername() {
        return user.getUsername();
    }

    public static String getProfileDescription() {
        return user.getDescription();
    }


    public static void setAvatarImage(Bitmap avatarImage) {
        user.setAvatar(avatarImage);
    }

    public static void setUsername(String username) {
        user.setUsername(username);
    }

    public static void setProfileDescription(String description) {
        user.setDescription(description);
    }
}
