package com.example.communityapp.Controllers;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.communityapp.Entities.UserEntity;
import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

public class UserController {

    private static UserEntity user;

    public static boolean login(String username, String password) {

        if(!username.equals("admin") || !password.equals("admin"))
            return false;

        user = new UserEntity();

        Activity activity = MainActivity.getMainActivity();
        Bitmap profileAvatar = BitmapFactory.decodeResource(activity.getResources(), R.drawable.wolf);

        user.setAvatarBitmap(profileAvatar);
        user.setUsername("Жак Фреско");
        user.setDescription("Я баллически-эллипсический объект\nЯ гендерно реверсивно ориентированный");

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
        user.setAvatarBitmap(avatarImage);
    }

    public static void setUsername(String username) {
        user.setUsername(username);
    }

    public static void setProfileDescription(String description) {
        user.setDescription(description);
    }
}
