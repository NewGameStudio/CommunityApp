package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.Master.DataMaster;
import com.example.communityapp.R;


public class FreelancerTaskViewFragment extends Fragment {

    private FreelanceTaskEntity freelanceTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_freelancer_task_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        freelanceTask = DataMaster.getCurrentFreelanceTask();

        setTaskData();
    }

    private void setTaskData() {
        TextView taskDescription = getView().findViewById(R.id.task_description);
        taskDescription.setText(freelanceTask.getDescription());

        taskDescription.setMovementMethod(new ScrollingMovementMethod());
    }
}