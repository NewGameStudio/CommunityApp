package com.example.communityapp.Adapter;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.Review;
import com.example.communityapp.Entities.User;
import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mainLayout;
        public TextView userName;
        public TextView reviewText;
        public TextView reviewPublDate;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);

            mainLayout = itemView.findViewById(R.id.review_card_main_layout);
            userName = itemView.findViewById(R.id.user_name);
            reviewText = itemView.findViewById(R.id.review_text);
            reviewPublDate = itemView.findViewById(R.id.review_publ_date);
        }
    }


    private List<Review> reviews;

    public ReviewAdapter(List<Review> reviews) {
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_card_view, parent, false);

        return new ReviewAdapter.ReviewViewHolder(view);
    }

    @SuppressLint({"ResourceAsColor", "UseCompatLoadingForDrawables"})
    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

        Review review = reviews.get(position);

        User reviewOwner = UserController.findUserById(review.getOwnerId());
        
        Drawable drawable = MainActivity.getMainActivity().getDrawable(R.drawable.shape_rectangle_green);

        if(review.getScore() < 0)
            drawable = MainActivity.getMainActivity().getDrawable(R.drawable.shape_rectangle_red);

        holder.mainLayout.setBackground(drawable);
        holder.userName.setText(reviewOwner.getUsername());
        holder.reviewText.setText(review.getReviewText());
        holder.reviewPublDate.setText("23.12.2020");
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
}
