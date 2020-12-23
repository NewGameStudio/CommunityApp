package com.example.communityapp.Adapter;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.ChatRoom;
import com.example.communityapp.Entities.User;
import com.example.communityapp.R;

import java.util.List;

public class ChatRoomAdapter extends RecyclerView.Adapter<ChatRoomAdapter.MessageViewHolder> {


    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layout;
        private TextView userName;
        private TextView message;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.message_main_layout);
            userName = itemView.findViewById(R.id.user_name);
            message = itemView.findViewById(R.id.message_text);
        }
    }


    private User user;
    private User companion;
    private ChatRoom chatRoom;

    public ChatRoomAdapter(User user, User companion, ChatRoom chatRoom) {
        this.user = user;
        this.companion = companion;
        this.chatRoom = chatRoom;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_card_view, parent, false);

        return new ChatRoomAdapter.MessageViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        List<String> messages = chatRoom.getMessages();
        List<Integer> ownerIDs = chatRoom.getOwnerIDs();

        String name = companion.getUsername();
        String message = messages.get(position);

        if(ownerIDs.get(position) == UserController.getUser().getId()) {
            name = user.getUsername();
            holder.userName.setGravity(Gravity.END);

            holder.message.setGravity(Gravity.END);
            holder.message.setTextColor(R.color.colorBlack);

            holder.layout.setBackgroundTintList(ColorStateList.valueOf(R.color.white));
            holder.layout.setBackgroundTintMode(PorterDuff.Mode.CLEAR);
        }

        holder.userName.setText(name);
        holder.message.setText(message);
    }

    @Override
    public int getItemCount() {
        return chatRoom.getMessages().size();
    }
}
