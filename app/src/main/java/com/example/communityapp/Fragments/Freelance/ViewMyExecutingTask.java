package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.communityapp.Controllers.FreelanceTasksController;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.Entities.User;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

import org.w3c.dom.Text;

public class ViewMyExecutingTask extends Fragment {

    private FreelanceTask freelanceTask;
    private User taskExecutor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_view_my_executing_task,
                container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        freelanceTask = FreelanceFragmentsDataContainer.getCurrentViewFreelanceTask();
        taskExecutor = UserController.findUserById(freelanceTask.getTaskExecutorId());

        setTaskData();
    }

    private void setTaskData() {
        TextView taskTitle = getView().findViewById(R.id.task_title);
        TextView taskDescription = getView().findViewById(R.id.task_description);
        TextView taskPublDate = getView().findViewById(R.id.task_public_date);
        TextView taskExpLeft = getView().findViewById(R.id.task_exp_left);
        TextView taskClass = getView().findViewById(R.id.task_class);
        TextView taskSubject = getView().findViewById(R.id.task_subject);
        TextView taskPrice = getView().findViewById(R.id.task_price);
        TextView taskExecutorName = getView().findViewById(R.id.executor_name);

        taskDescription.setMovementMethod(new ScrollingMovementMethod());

        taskTitle.setText(freelanceTask.getTitle());
        taskDescription.setText(freelanceTask.getDescription());
        taskPublDate.setText(DateUtil.standardDateToString(freelanceTask.getPublicationDate()));
        taskExpLeft.setText(("Дата сдачи: " + DateUtil.standardDateToString(freelanceTask.getExpirationDate())));
        taskClass.setText(Integer.toString(freelanceTask.getClassIndex()) + " класс");
        taskSubject.setText(freelanceTask.getSubjectName());
        taskPrice.setText(Integer.toString(freelanceTask.getPrice()) + " руб");
        taskExecutorName.setText(taskExecutor.getUsername());
    }
}
