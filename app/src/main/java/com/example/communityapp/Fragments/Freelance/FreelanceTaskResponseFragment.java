package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;


public class FreelanceTaskResponseFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_freelance_task_response, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button sendResponseButton = getView().findViewById(R.id.send_response_btn);
        sendResponseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "Отклик отправлен", Toast.LENGTH_SHORT).show();
        NavigationMaster.navigate(getView(), R.id.action_freelanceTaskResponseFragment_to_nav_freelance);
    }
}