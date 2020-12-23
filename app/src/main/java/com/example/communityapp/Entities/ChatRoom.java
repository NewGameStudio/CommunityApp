package com.example.communityapp.Entities;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom extends BaseEntity {

    private int user1Id;
    private int user2Id;
    private List<String> messages = new ArrayList<>();
    private List<Integer> ownerIDs = new ArrayList<>();

    public ChatRoom(int user1Id, int user2Id) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
    }

    public int getUser1Id() {
        return user1Id;
    }

    public int getUser2Id() {
        return user2Id;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Integer> getOwnerIDs() {
        return ownerIDs;
    }

    public void setOwnerIDs(List<Integer> ownerIDs) {
        this.ownerIDs = ownerIDs;
    }
}
