package com.example.communityapp.Entities;

import android.graphics.Bitmap;

public class UserEntity {

    private Bitmap avatar;
    private String username;
    private String description;

    public void setAvatarBitmap(Bitmap avatar) {
        this.avatar = avatar;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Bitmap getAvatar() {
        return avatar;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }
}
