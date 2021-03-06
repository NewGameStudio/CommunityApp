package com.example.communityapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.Entities.User;
import com.example.communityapp.Handlers.OnClickItemListener;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

import java.util.List;

public class FreelanceTaskAdapter
        extends RecyclerView.Adapter<FreelanceTaskAdapter.FreelanceTaskViewHolder> {

    public static class FreelanceTaskViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView taskTitle;
        public TextView taskDescription;
        public TextView taskPublDate;
        public TextView taskExpLeft;
        public TextView taskClass;
        public TextView taskSubject;
        public TextView taskRelation;
        public TextView taskPrice;
        public TextView taskOwnerName;
        public ImageView taskResponsesIcon;
        public TextView taskResponses;
        public TextView taskStatus;
        private OnClickItemListener onClickItemListener;

        public FreelanceTaskViewHolder(@NonNull View itemView, OnClickItemListener onClickItemListener) {
            super(itemView);

            taskTitle = itemView.findViewById(R.id.task_title);
            taskDescription = itemView.findViewById(R.id.task_description);
            taskPublDate = itemView.findViewById(R.id.task_public_date);
            taskExpLeft = itemView.findViewById(R.id.task_exp_left);
            taskClass = itemView.findViewById(R.id.task_class);
            taskSubject = itemView.findViewById(R.id.task_subject);
            taskRelation = itemView.findViewById(R.id.task_relation);
            taskPrice = itemView.findViewById(R.id.task_price);
            taskOwnerName = itemView.findViewById(R.id.task_owner_name);
            taskResponsesIcon = itemView.findViewById(R.id.task_responses_icon);
            taskResponses = itemView.findViewById(R.id.task_responses);
            taskStatus = itemView.findViewById(R.id.task_status);

            this.onClickItemListener = onClickItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickItemListener.onItemClick(getAdapterPosition());
        }
    }


    private List<FreelanceTask> tasks;
    private OnClickItemListener onClickItemListener;

    public FreelanceTaskAdapter(List<FreelanceTask> tasks, OnClickItemListener onClickItemListener) {
        this.tasks = tasks;
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public FreelanceTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.freelance_task_card_view, parent, false);

        return new FreelanceTaskViewHolder(view, onClickItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FreelanceTaskViewHolder holder, int position) {
        FreelanceTask currentTask = tasks.get(position);

        User taskOwner = UserController.findUserById(currentTask.getTaskOwnerId());

        holder.taskTitle.setText(currentTask.getTitle());
        holder.taskDescription.setText(currentTask.getDescription());
        holder.taskPublDate.setText(DateUtil.standardDateToString(currentTask.getPublicationDate()));
        holder.taskExpLeft.setText(("Дата сдачи: " + DateUtil.standardDateToString(currentTask.getExpirationDate())));
        holder.taskClass.setText(Integer.toString(currentTask.getClassIndex()) + " класс");
        holder.taskSubject.setText(currentTask.getSubjectName());
        holder.taskPrice.setText(Integer.toString(currentTask.getPrice()) + " руб");
        holder.taskOwnerName.setText(taskOwner.getUsername());

        if(currentTask.getTaskExecutorId() == -1) {
            holder.taskResponses.setText("откликов : " + currentTask.getResponsesCount());
        }
        else {
            holder.taskResponsesIcon.setVisibility(View.GONE);
            holder.taskResponses.setVisibility(View.GONE);
            holder.taskStatus.setVisibility(View.VISIBLE);
        }

        if(taskOwner.getId() == UserController.getUser().getId())
            holder.taskRelation.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
