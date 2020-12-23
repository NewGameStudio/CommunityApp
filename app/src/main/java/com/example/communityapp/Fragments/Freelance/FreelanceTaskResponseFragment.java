package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.communityapp.Controllers.FreelanceTasksController;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.Entities.Response;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;


public class FreelanceTaskResponseFragment extends Fragment implements View.OnClickListener {

    FreelanceTask freelanceTask;
    private TextInputLayout priceInputLayout;
    private TextInputLayout taskCompeleteDateLayout;
    private TextInputLayout descriptionLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_freelance_task_response, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        freelanceTask = FreelanceFragmentsDataContainer.getCurrentViewFreelanceTask();

        setTaskData();

        priceInputLayout = getView().findViewById(R.id.price_input_layout);
        taskCompeleteDateLayout = getView().findViewById(R.id.task_compelete_date_layout);
        descriptionLayout = getView().findViewById(R.id.task_description_layout);

        Button sendResponseButton = getView().findViewById(R.id.send_response_btn);
        sendResponseButton.setOnClickListener(this);
    }

    private void setTaskData() {
        TextView taskTitle = getView().findViewById(R.id.task_title);
        TextView taskDescription = getView().findViewById(R.id.task_description);
        TextView taskPublDate = getView().findViewById(R.id.task_public_date);
        TextView taskClass = getView().findViewById(R.id.task_class);
        TextView taskSubject = getView().findViewById(R.id.task_subject);
        TextView taskResponses = getView().findViewById(R.id.task_responses);

        taskTitle.setText(freelanceTask.getTitle());
        taskDescription.setText(freelanceTask.getDescription());
        taskPublDate.setText(DateUtil.standardDateToString(freelanceTask.getPublicationDate()));
        taskClass.setText(Integer.toString(freelanceTask.getClassIndex()) + " класс");
        taskSubject.setText(freelanceTask.getSubjectName());
        taskResponses.setText("откликов : " + freelanceTask.getResponsesCount());
    }

    @Override
    public void onClick(View view) {
        int price = Integer.parseInt(priceInputLayout.getEditText().getText().toString());
        Date date = DateUtil.toDateStandard(taskCompeleteDateLayout.getEditText().getText().toString());
        String description = descriptionLayout.getEditText().getText().toString();

        Response response = new Response(UserController.getUser().getId(), freelanceTask.getId());
        response.setPrice(price);
        response.setCompletionDate(date);
        response.setDescription(description);

        FreelanceTasksController.respondToTask(freelanceTask.getId(), response);

        Toast.makeText(getActivity(), "Отклик отправлен", Toast.LENGTH_SHORT).show();
        NavigationMaster.navigate(getView(),
                R.id.action_freelanceTaskResponseFragment_to_nav_freelance);
    }
}