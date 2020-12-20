package com.example.communityapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class FreelanceTaskAdapter extends RecyclerView.Adapter<FreelanceTaskAdapter.FreelanceTaskViewHolder> {


    public static class FreelanceTaskViewHolder extends RecyclerView.ViewHolder {

        public TextView taskTitle;
        public TextView taskPublDate;
        public TextView taskExpLeft;
        public TextView taskClass;
        public TextView taskPrice;

        public FreelanceTaskViewHolder(@NonNull View itemView) {
            super(itemView);

            taskTitle = itemView.findViewById(R.id.freelance_task_title);
            taskPublDate = itemView.findViewById(R.id.freelance_task_publ_date);
            taskExpLeft = itemView.findViewById(R.id.freelance_task_exp_left);
            taskClass = itemView.findViewById(R.id.freelance_task_class);
            taskPrice = itemView.findViewById(R.id.freelance_task_price);
        }
    }

    private List<FreelanceTaskEntity> tasks;

    public FreelanceTaskAdapter(List<FreelanceTaskEntity> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public FreelanceTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.freelance_task_card_view, parent, false);

        return new FreelanceTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FreelanceTaskViewHolder holder, int position) {
        FreelanceTaskEntity currentTask = tasks.get(position);

        holder.taskTitle.setText(currentTask.getTitle());
        holder.taskPublDate.setText(DateUtil.standardDateToString(currentTask.getPublicationDate()));
        holder.taskExpLeft.setText(("Дата сдачи: " + DateUtil.standardDateToString(currentTask.getExpirationDate())));
        holder.taskClass.setText(Integer.toString(currentTask.getClassIndex()) + " класс");
        holder.taskPrice.setText(Integer.toString(currentTask.getPrice()) + " руб");
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
