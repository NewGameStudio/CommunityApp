package com.example.communityapp.Entities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

import java.util.List;

public class User extends BaseEntity{

    private Bitmap avatar;
    private String username;
    private String password;
    private String description;
    private List<Integer> publicatedTasksIDs;
    private List<Integer> executableTasksIDs;


    public Bitmap getAvatar() {

        if(avatar == null) {
            Activity activity = MainActivity.getMainActivity();
            return BitmapFactory.decodeResource(activity.getResources(),
                    R.drawable.blank_profile);
        }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getPublicatedTasksIDs() {
        return publicatedTasksIDs;
    }

    public void setPublicatedTasksIDs(List<Integer> publicatedTasksIDs) {
        this.publicatedTasksIDs = publicatedTasksIDs;
    }

    public List<Integer> getExecutableTasksIDs() {
        return executableTasksIDs;
    }

    public void setExecutableTasksIDs(List<Integer> executableTasksIDs) {
        this.executableTasksIDs = executableTasksIDs;
    }
}
