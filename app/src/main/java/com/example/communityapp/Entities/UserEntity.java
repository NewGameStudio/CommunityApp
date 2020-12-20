package com.example.communityapp.Entities;

import android.graphics.Bitmap;

import java.util.List;

public class UserEntity {

    private Bitmap avatar;
    private String username;
    private String description;
    private List<FreelanceTaskEntity> publicatedTasks;
    private List<FreelanceTaskEntity> executableTasks;


    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FreelanceTaskEntity> getPublicatedTasks() {
        return publicatedTasks;
    }

    public void setPublicatedTasks(List<FreelanceTaskEntity> publicatedTasks) {
        this.publicatedTasks = publicatedTasks;
    }

    public List<FreelanceTaskEntity> getExecutableTasks() {
        return executableTasks;
    }

    public void setExecutableTasks(List<FreelanceTaskEntity> executableTasks) {
        this.executableTasks = executableTasks;
    }
}
