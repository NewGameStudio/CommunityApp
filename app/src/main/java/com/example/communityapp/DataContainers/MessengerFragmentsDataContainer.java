package com.example.communityapp.DataContainers;

import com.example.communityapp.Entities.ChatRoom;

public class MessengerFragmentsDataContainer {

    private static ChatRoom chatRoom;

    public static ChatRoom getChatRoom() {
        return chatRoom;
    }

    public static void setChatRoom(ChatRoom chatRoom) {
        MessengerFragmentsDataContainer.chatRoom = chatRoom;
    }
}
