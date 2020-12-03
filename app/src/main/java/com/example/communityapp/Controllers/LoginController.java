package com.example.communityapp.Controllers;

public class LoginController {

    public static boolean login(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
