package com.example.communityapp.Controllers;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.communityapp.Entities.User;
import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private static User user;
    private static List<User> users;

    //TODO remove this
    private static void init() {
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("Дима Шелохвостов");
        user1.setDescription("Дебик");

        User user2 = new User();
        user2.setId(3);
        user2.setUsername("Отец Даниил");
        user2.setDescription("Не дебик");

        users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
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


    public static User findUserById(int id) {
        for(User user : users) {
            if(user.getId() == id)
                return user;
        }

        return null;
    }
}
