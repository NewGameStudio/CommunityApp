package com.example.communityapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.Response;
import com.example.communityapp.Entities.User;
import com.example.communityapp.Handlers.OnClickItemListener;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

import java.util.List;

public class ResponseAdapter
        extends RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder> {

    public static class ResponseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView responseOwnerName;
        public TextView responseDescription;
        public TextView responseComplDate;
        public TextView responsePrice;
        private OnClickItemListener onClickItemListener;

        public ResponseViewHolder(@NonNull View itemView, OnClickItemListener onClickItemListener) {
            super(itemView);

            responseOwnerName = itemView.findViewById(R.id.response_owner_name);
            responseDescription = itemView.findViewById(R.id.response_description);
            responseComplDate = itemView.findViewById(R.id.response_compl_date);
            responsePrice = itemView.findViewById(R.id.response_price);
            this.onClickItemListener = onClickItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickItemListener.onItemClick(getAdapterPosition());
        }
    }


    private List<Response> responses;
    private OnClickItemListener onClickItemListener;

    public ResponseAdapter(List<Response> responses, OnClickItemListener onClickItemListener) {
        this.responses = responses;
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.freelance_response_card_view, parent, false);

        return new ResponseAdapter.ResponseViewHolder(view, onClickItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseViewHolder holder, int position) {
        Response response = responses.get(position);

        User responseOwner = UserController.findUserById(response.getOwnerId());

        holder.responseOwnerName.setText(responseOwner.getUsername());
        holder.responseDescription.setText(response.getDescription());
        holder.responseComplDate.setText("Дата выполнения: " +
                DateUtil.standardDateToString(response.getCompletionDate()));
        holder.responsePrice.setText(Integer.toString(response.getPrice()) + " руб");
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }
}
