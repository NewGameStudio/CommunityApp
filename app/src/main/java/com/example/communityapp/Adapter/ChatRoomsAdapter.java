package com.example.communityapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.ChatRoom;
import com.example.communityapp.Entities.User;
import com.example.communityapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class ChatRoomsAdapter extends RecyclerView.Adapter<ChatRoomsAdapter.ChatRoomViewHolder> {


    public static class ChatRoomViewHolder extends RecyclerView.ViewHolder {

        public TextView userName;

        public ChatRoomViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.chat_user_name);
        }
    }


    private User user;
    private List<ChatRoom> chatRooms;

    public ChatRoomsAdapter(User user, List<ChatRoom> chatRooms) {
        this.user = user;
        this.chatRooms = chatRooms;
    }

    @NonNull
    @Override
    public ChatRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_icon_card, parent, false);

        return new ChatRoomsAdapter.ChatRoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatRoomViewHolder holder, int position) {
        ChatRoom chatRoom = chatRooms.get(position);

        User companion = null;

        if(user.getId() == chatRoom.getUser1Id())
            companion = UserController.findUserById(chatRoom.getUser2Id());
        else
            companion = UserController.findUserById(chatRoom.getUser1Id());

        holder.userName.setText(companion.getUsername());
    }

    @Override
    public int getItemCount() {
        return chatRooms.size();
    }
}
