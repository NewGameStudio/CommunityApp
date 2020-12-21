package com.example.communityapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Entities.TextbookTaskSolution;
import com.example.communityapp.R;

import java.util.ArrayList;

public class TextbookTaskSolutionAdapter extends RecyclerView.Adapter<TextbookTaskSolutionAdapter.GdzTaskSolutionViewHolder> {

    public static class GdzTaskSolutionViewHolder extends RecyclerView.ViewHolder {

        public TextView userTitle;
        public ImageView userAvatar;
        public TextView score;

        public GdzTaskSolutionViewHolder(@NonNull View itemView) {
            super(itemView);

            userTitle = itemView.findViewById(R.id.task_profile_name);
            userAvatar = itemView.findViewById(R.id.task_profile_avatar);
            score = itemView.findViewById(R.id.task_score);
        }
    }


    private ArrayList<TextbookTaskSolution> taskSolutions;

    public TextbookTaskSolutionAdapter(ArrayList<TextbookTaskSolution> taskSolutions) {
        this.taskSolutions = taskSolutions;
    }

    @NonNull
    @Override
    public TextbookTaskSolutionAdapter.GdzTaskSolutionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.textbook_task_solution_card_view, parent, false);

        return new TextbookTaskSolutionAdapter.GdzTaskSolutionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextbookTaskSolutionAdapter.GdzTaskSolutionViewHolder holder, int position) {
        TextbookTaskSolution currnetSolution = taskSolutions.get(position);

        holder.userTitle.setText("Переделать");
        holder.score.setText(Integer.toString(currnetSolution.getScore()));
//        holder.userAvatar.setImageResource(currnetSolution.taskOwner.getAvatar());
    }

    @Override
    public int getItemCount() {
        return taskSolutions.size();
    }
}
