package com.example.communityapp.Fragments.Messenger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Adapter.ChatRoomAdapter;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.DataContainers.MessengerFragmentsDataContainer;
import com.example.communityapp.Entities.ChatRoom;
import com.example.communityapp.Entities.User;
import com.example.communityapp.R;

public class ChatRoomFragment extends Fragment {

    private User user1;
    private User user2;
    private ChatRoom chatRoom;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_screen, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        chatRoom = MessengerFragmentsDataContainer.getChatRoom();
        user1 = UserController.findUserById(chatRoom.getUser1Id());
        user2 = UserController.findUserById(chatRoom.getUser2Id());

        initializeRecyclerView();

        RecyclerView.Adapter recyclerAdapter = new ChatRoomAdapter(user1, user2, chatRoom);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initializeRecyclerView() {
        recyclerView = getView().findViewById(R.id.chat_room_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}
