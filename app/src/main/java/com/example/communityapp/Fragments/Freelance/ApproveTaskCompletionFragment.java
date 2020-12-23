package com.example.communityapp.Fragments.Freelance;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.communityapp.Controllers.FreelanceTasksController;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.Entities.Review;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;
import com.google.android.material.textfield.TextInputEditText;

public class ApproveTaskCompletionFragment extends Fragment implements View.OnClickListener {

    private Button niceSmileGreenBtn;
    private Button niceSmileWhiteBtn;

    private Button notNiceSmileRedBtn;
    private Button notNiceSmileWhiteBtn;

    private TextInputEditText reviewEditText;
    private Button approveBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.approve_task_completion, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        niceSmileGreenBtn = getView().findViewById(R.id.nice_smile_green);
        niceSmileWhiteBtn = getView().findViewById(R.id.nice_smile_white);

        notNiceSmileRedBtn = getView().findViewById(R.id.not_nice_smile_red);
        notNiceSmileWhiteBtn = getView().findViewById(R.id.not_nice_smile_white);

        reviewEditText = getView().findViewById(R.id.task_review_edit_text);
        approveBtn = getView().findViewById(R.id.approve_btn);

        niceSmileGreenBtn.setOnClickListener(this);
        niceSmileWhiteBtn.setOnClickListener(this);

        notNiceSmileRedBtn.setOnClickListener(this);
        notNiceSmileWhiteBtn.setOnClickListener(this);

        approveBtn.setOnClickListener(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.not_nice_smile_white) {
            notNiceSmileWhiteBtn.setVisibility(View.GONE);
            notNiceSmileRedBtn.setVisibility(View.VISIBLE);

            niceSmileGreenBtn.setVisibility(View.GONE);
            niceSmileWhiteBtn.setVisibility(View.VISIBLE);
        }
        else if(view.getId() == R.id.nice_smile_white) {
            notNiceSmileWhiteBtn.setVisibility(View.VISIBLE);
            notNiceSmileRedBtn.setVisibility(View.GONE);

            niceSmileGreenBtn.setVisibility(View.VISIBLE);
            niceSmileWhiteBtn.setVisibility(View.GONE);

        } else if(view.getId() == R.id.approve_btn) {

            FreelanceTask freelanceTask = FreelanceFragmentsDataContainer.getCurrentViewFreelanceTask();
            int score = niceSmileGreenBtn.getVisibility() == View.VISIBLE ? 1 : -1;

            Review review = new Review(freelanceTask.getTaskOwnerId(),
                    freelanceTask.getTaskExecutorId(), score);

            review.setReviewText(reviewEditText.getText().toString());
            review.setPublicationDate(DateUtil.toDateStandard("23.12.2020"));
            review.setScore(score);

            FreelanceTasksController.approveTaskCompletion(freelanceTask.getId(), review);

            NavigationMaster.navigate(getView(), R.id.action_approveTaskCompletionFragment_to_nav_freelance);
        }
    }
}
