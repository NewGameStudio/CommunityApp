package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

public class PublishFreelanceTask4 extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_publish_freelance_task4, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button nextButton = getView().findViewById(R.id.next_btn);
        nextButton.setOnClickListener(this);

        Button previousButton = getView().findViewById(R.id.previous_btn);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.next_btn)
            NavigationMaster.navigate(getView(),
                    R.id.action_publishFreelanceTask4_to_publishFreelanceTaskFinal);

        else if(view.getId() == R.id.previous_btn)
            NavigationMaster.navigate(getView(),
                    R.id.action_publishFreelanceTask4_to_publishFreelanceTask3);
    }
}
