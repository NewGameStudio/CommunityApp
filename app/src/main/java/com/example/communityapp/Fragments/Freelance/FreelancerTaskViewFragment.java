package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.communityapp.R;


public class FreelancerTaskViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_freelancer_task_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        TextView taskDescription = getActivity().findViewById(R.id.task_description);

        taskDescription.setMovementMethod(new ScrollingMovementMethod());
    }
}