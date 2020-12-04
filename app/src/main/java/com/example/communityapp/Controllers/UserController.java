package com.example.communityapp.Controllers;

public class UserController {

    public static boolean login(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
