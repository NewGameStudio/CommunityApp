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
        user1.setUsername("admin");
        user1.setPassword("admin");
        user1.setDescription("Я мячик");

        User user2 = new User();
        user2.setUsername("Дима Шелохвостов");
        user2.setPassword("admin");
        user2.setDescription("Дебик");

        User user3 = new User();
        user3.setUsername("Отец Даниил");
        user3.setPassword("admin");
        user3.setDescription("Не дебик");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public static boolean login(String username, String password) {

        //TODO delete this
        init();

        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                UserController.user = user;
                break;
            }
        }

        //TODO delete this
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

    public static User findUserByName(String name) {
        for(User user : users) {
            if(user.getUsername() == name)
                return user;
        }

        return null;
    }
}
