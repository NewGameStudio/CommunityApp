package com.example.communityapp.Fragments.Messenger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ChatRoomFragment extends Fragment implements View.OnClickListener {

    private User user1;
    private User user2;
    private ChatRoom chatRoom;

    private TextInputEditText messageEditText;
    private MaterialButton sendBtn;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_screen, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        messageEditText = getView().findViewById(R.id.chat_message_field);
        sendBtn = getView().findViewById(R.id.send_message_btn);

        chatRoom = MessengerFragmentsDataContainer.getChatRoom();
        user1 = UserController.findUserById(chatRoom.getUser1Id());
        user2 = UserController.findUserById(chatRoom.getUser2Id());

        initializeRecyclerView();

        User user = UserController.getUser();
        User companion = user.getId() == user1.getId() ? user2 : user1;

        RecyclerView.Adapter recyclerAdapter = new ChatRoomAdapter(user, companion, chatRoom);
        recyclerView.setAdapter(recyclerAdapter);

        sendBtn.setOnClickListener(this);
    }

    private void initializeRecyclerView() {
        recyclerView = getView().findViewById(R.id.chat_room_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(false);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.send_message_btn) {

            String message = messageEditText.getText().toString();

            if(message.equals(""))
                return;

            List<String> messages = chatRoom.getMessages();
            List<Integer> ownerIDs = chatRoom.getOwnerIDs();

            messages.add(message);
            ownerIDs.add(UserController.getUser().getId());

            chatRoom.setMessages(messages);
            chatRoom.setOwnerIDs(ownerIDs);

            User user = UserController.getUser();
            User companion = user.getId() == user1.getId() ? user2 : user1;

            RecyclerView.Adapter recyclerAdapter = new ChatRoomAdapter(user, companion, chatRoom);
            recyclerView.setAdapter(recyclerAdapter);

            messageEditText.setText("");
            messageEditText.clearFocus();
        }
    }
}
