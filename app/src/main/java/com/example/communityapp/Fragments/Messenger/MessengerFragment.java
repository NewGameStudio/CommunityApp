package com.example.communityapp.Fragments.Messenger;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.communityapp.Adapter.ChatRoomsAdapter;
import com.example.communityapp.Adapter.FreelanceTaskAdapter;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.DataContainers.MessengerFragmentsDataContainer;
import com.example.communityapp.Entities.ChatRoom;
import com.example.communityapp.Entities.User;
import com.example.communityapp.Handlers.OnClickItemListener;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

import java.util.List;

public class MessengerFragment extends Fragment implements OnClickItemListener {

    private User user;
    private List<ChatRoom> chatRooms;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_messenger, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        initializeRecyclerView();

        user = UserController.getUser();
        chatRooms = UserController.findAllUserChatRooms(user.getId());

        RecyclerView.Adapter recyclerAdapter = new ChatRoomsAdapter(user, chatRooms,
                this);

        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initializeRecyclerView() {
        recyclerView = getView().findViewById(R.id.chats_recycler);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(int itemIndex) {
        MessengerFragmentsDataContainer.setChatRoom(chatRooms.get(itemIndex));
        NavigationMaster.navigate(getView(), R.id.action_nav_messenger_to_chatRoomFragment);
    }
}