package com.example.communityapp.Controllers;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.communityapp.Entities.ChatRoom;
import com.example.communityapp.Entities.Review;
import com.example.communityapp.Entities.User;
import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserController {

    private static User user;
    private static List<User> users;
    private static List<Review> reviews = new ArrayList<>();
    private static List<ChatRoom> chatRooms = new ArrayList<>();

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
        user3.setUsername("admin2");
        user3.setPassword("admin");
        user3.setDescription("Не дебик");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Review review = new Review(user2.getId(), user1.getId(), 1);
        review.setReviewText("Нормально");
        postReview(review);

        review = new Review(user3.getId(), user1.getId(), -1);
        review.setReviewText("Ненормально");
        postReview(review);

        createChatRoom(user1.getId(), user2.getId());
        ChatRoom chatRoom = findChatRoom(user1.getId(), user2.getId());
        List<String> messages = new ArrayList<>(Arrays.asList("Привет", "Пошёл ты"));
        List<Integer> messageOwnerIds = new ArrayList<>(Arrays.asList(user1.getId(), user2.getId()));
        chatRoom.setMessages(messages);
        chatRoom.setOwnerIDs(messageOwnerIds);
    }

    public static boolean login(String username, String password) {

        //TODO delete this
        boolean initialized = (users != null && users.size() > 0);

        //TODO delete this
        if(!initialized)
            init();

        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                UserController.user = user;
                break;
            }
        }

        //TODO delete this
        if(!initialized) {
            TextbooksController.init();
            FreelanceTasksController.init();
        }

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


    public static List<Review> findAboutUserReviews(int userId) {
        ArrayList<Review> userReviews = new ArrayList<>();

        for(Review review : reviews) {
            if(review.getEmployeeId() == userId)
                userReviews.add(review);
        }

        return userReviews;
    }

    public static void postReview(Review review) {
        reviews.add(review);
    }


    public static List<ChatRoom> findAllUserChatRooms(int userId) {
        ArrayList<ChatRoom> userRooms = new ArrayList<>();

        for(ChatRoom chatRoom : chatRooms) {
            if(chatRoom.getUser1Id() == userId || chatRoom.getUser2Id() == userId)
                userRooms.add(chatRoom);
        }

        return userRooms;
    }

    public static ChatRoom createChatRoom(int user1Id, int user2Id) {
        ChatRoom chatRoom = new ChatRoom(user1Id, user2Id);

        chatRooms.add(chatRoom);

        return chatRoom;
    }

    public static ChatRoom findChatRoom(int user1Id, int user2Id) {
        for(ChatRoom chatRoom : chatRooms) {

            if(chatRoom.getUser1Id() == user1Id && chatRoom.getUser2Id() == user2Id)
                return chatRoom;

            if(chatRoom.getUser1Id() == user2Id && chatRoom.getUser2Id() == user1Id)
                return chatRoom;
        }

        return null;
    }

    public static ChatRoom findChatRoomOrCreateNew(int user1Id, int user2Id) {

        ChatRoom chatRoom = findChatRoom(user1Id, user2Id);

        if(chatRoom != null)
            return chatRoom;

        return createChatRoom(user1Id, user2Id);
    }
}
