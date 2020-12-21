package com.example.communityapp.Controllers;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.communityapp.Entities.User;
import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

import java.util.List;

public class UserController {

    private static User user;
    private List<User> users;

    //TODO remove this
    private static void init() {

    }

    public static boolean login(String username, String password) {

        if(!username.equals("admin") || !password.equals("admin"))
            return false;

        user = new User();

        Activity activity = MainActivity.getMainActivity();
        Bitmap profileAvatar = BitmapFactory.decodeResource(activity.getResources(),
                R.drawable.blank_profile);

        user.setId(1);
        user.setAvatar(profileAvatar);
        user.setUsername("Стас АйКакПросто");
        user.setDescription("Я мячик");

        //TODO delete this
        init();
        TextbooksController.init();
        FreelanceTasksController.init();

        return true;
    }

    public static void logout() {

    }

    public static User getUser() {
        return user;
    }
}
