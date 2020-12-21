package com.example.communityapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Entities.BookEntity;
import com.example.communityapp.Entities.TaskEntity;
import com.example.communityapp.Entities.TaskSolution;
import com.example.communityapp.R;

import java.util.ArrayList;

public class GdzTaskSolutionAdapter extends RecyclerView.Adapter<GdzTaskSolutionAdapter.GdzTaskSolutionViewHolder> {

    public static class GdzTaskSolutionViewHolder extends RecyclerView.ViewHolder {

        public TextView userTitle;
        public ImageView userAvatar;
        public TextView rating;

        public GdzTaskSolutionViewHolder(@NonNull View itemView) {
            super(itemView);

            userTitle = itemView.findViewById(R.id.task_profile_name);
            userAvatar = itemView.findViewById(R.id.task_profile_avatar);
            rating = itemView.findViewById(R.id.task_rating);
        }
    }

    private ArrayList<TaskSolution> taskSolutions;

    public GdzTaskSolutionAdapter(ArrayList<TaskSolution> taskSolutions) {
        this.taskSolutions = taskSolutions;
    }

    @NonNull
    @Override
    public GdzTaskSolutionAdapter.GdzTaskSolutionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gdz_task_solution_card_view, parent, false);

        return new GdzTaskSolutionAdapter.GdzTaskSolutionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GdzTaskSolutionAdapter.GdzTaskSolutionViewHolder holder, int position) {
        TaskSolution currnetSolution = taskSolutions.get(position);

        holder.userTitle.setText(currnetSolution.taskOwner.getUsername());
        holder.rating.setText(Integer.toString(currnetSolution.rating));
//        holder.userAvatar.setImageResource(currnetSolution.taskOwner.getAvatar());
    }

    @Override
    public int getItemCount() {
        return taskSolutions.size();
    }
}
