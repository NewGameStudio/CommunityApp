package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

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

        EditText expDateEditText = getView().findViewById(R.id.task_exp_date_edit_text);
        expDateEditText.setText("23.12.2020");

        Button previousButton = getView().findViewById(R.id.previous_btn);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.next_btn) {
            EditText expDateEditText = getView().findViewById(R.id.task_exp_date_edit_text);
            EditText taskPriceEditText = getView().findViewById(R.id.task_price_edit_text);

            if (taskPriceEditText.getText().toString().equals(""))
                taskPriceEditText.setText("0");

            FreelanceTask freelanceTask = FreelanceFragmentsDataContainer.getCurrentCreatingFreelanceTask();

            freelanceTask.setPrice(Integer.parseInt(taskPriceEditText.getText().toString()));
            freelanceTask.setPublicationDate(DateUtil.toDateStandard("23.12.2020"));
            freelanceTask.setExpirationDate(DateUtil.toDateStandard(expDateEditText.getText().toString()));

            FreelanceFragmentsDataContainer.setCurrentCreatingFreelanceTask(freelanceTask);

            NavigationMaster.navigate(getView(),
                    R.id.action_publishFreelanceTask4_to_publishFreelanceTaskFinal);
        }

        else if(view.getId() == R.id.previous_btn)
            NavigationMaster.navigate(getView(),
                    R.id.action_publishFreelanceTask4_to_publishFreelanceTask3);
    }
}
