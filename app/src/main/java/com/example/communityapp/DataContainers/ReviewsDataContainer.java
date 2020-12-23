package com.example.communityapp.DataContainers;

import com.example.communityapp.Entities.User;

public class ReviewsDataContainer {

    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        ReviewsDataContainer.currentUser = currentUser;
    }
}
