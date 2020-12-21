package com.example.communityapp.Entities;

import android.graphics.Bitmap;

import java.util.List;

public class User extends BaseEntity{

    private Bitmap avatar;
    private String username;
    private String description;
    private List<FreelanceTask> publicatedTasks;
    private List<FreelanceTask> executableTasks;


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

    public List<FreelanceTask> getPublicatedTasks() {
        return publicatedTasks;
    }

    public void setPublicatedTasks(List<FreelanceTask> publicatedTasks) {
        this.publicatedTasks = publicatedTasks;
    }

    public List<FreelanceTask> getExecutableTasks() {
        return executableTasks;
    }

    public void setExecutableTasks(List<FreelanceTask> executableTasks) {
        this.executableTasks = executableTasks;
    }
}