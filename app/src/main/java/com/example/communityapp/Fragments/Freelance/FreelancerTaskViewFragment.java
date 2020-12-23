package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;


public class FreelancerTaskViewFragment extends Fragment implements View.OnClickListener {

    private FreelanceTask freelanceTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_freelancer_task_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        freelanceTask = FreelanceFragmentsDataContainer.getCurrentViewFreelanceTask();

        setTaskData();

        Button respondButton = getView().findViewById(R.id.respond_btn);
        respondButton.setOnClickListener(this);
    }

    private void setTaskData() {
        TextView taskTitle = getView().findViewById(R.id.task_title);
        TextView taskDescription = getView().findViewById(R.id.task_description);
        TextView taskPublDate = getView().findViewById(R.id.task_public_date);
        TextView taskExpLeft = getView().findViewById(R.id.task_exp_left);
        TextView taskClass = getView().findViewById(R.id.task_class);
        TextView taskSubject = getView().findViewById(R.id.task_subject);
        TextView taskPrice = getView().findViewById(R.id.task_price);
        TextView taskResponses = getView().findViewById(R.id.task_responses);

        taskDescription.setMovementMethod(new ScrollingMovementMethod());

        taskTitle.setText(freelanceTask.getTitle());
        taskDescription.setText(freelanceTask.getDescription());
        taskPublDate.setText(DateUtil.standardDateToString(freelanceTask.getPublicationDate()));
        taskExpLeft.setText(("Дата сдачи: " + DateUtil.standardDateToString(freelanceTask.getExpirationDate())));
        taskClass.setText(Integer.toString(freelanceTask.getClassIndex()) + " класс");
        taskSubject.setText(freelanceTask.getSubjectName());
        taskPrice.setText(Integer.toString(freelanceTask.getPrice()) + " руб");
        taskResponses.setText("откликов : " + freelanceTask.getResponsesCount());
    }

    @Override
    public void onClick(View view) {
        NavigationMaster.navigate(getView(),
                R.id.action_freelancerTaskViewFragment_to_freelanceTaskResponseFragment);
    }
}