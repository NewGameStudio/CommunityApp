package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Adapter.ResponseAdapter;
import com.example.communityapp.Controllers.FreelanceTasksController;
import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.Entities.Response;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.Handlers.OnClickItemListener;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

import java.util.ArrayList;
import java.util.List;

public class FreelanceResponsesFragment extends Fragment implements OnClickItemListener {

    private List<Response> responses;
    private RecyclerView recyclerView;
    private FreelanceTask freelanceTask;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_responses_list, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        freelanceTask = FreelanceFragmentsDataContainer.getCurrentViewFreelanceTask();

        initializeTaskViews(freelanceTask);
        initializeRecyclerView();

        responses = new ArrayList<>();
        for(int id : freelanceTask.getResponsesIDs())
            responses.add(FreelanceTasksController.findResponseById(id));

        RecyclerView.Adapter recyclerAdapter = new ResponseAdapter(responses, this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initializeTaskViews(FreelanceTask freelanceTask) {
        TextView taskTitle = getView().findViewById(R.id.task_title);
        taskTitle.setText(freelanceTask.getTitle());

        TextView taskClass = getView().findViewById(R.id.task_class);
        taskClass.setText(Integer.toString(freelanceTask.getClassIndex()) + " класс");

        TextView taskSubject = getView().findViewById(R.id.task_subject);
        taskSubject.setText(freelanceTask.getSubjectName());
    }

    private void initializeRecyclerView() {
        recyclerView = getView().findViewById(R.id.freelance_responses_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(int itemIndex) {
        FreelanceFragmentsDataContainer.setCurrentViewResponse(responses.get(itemIndex));
        NavigationMaster.navigate(getView(), R.id.action_freelanceResponsesFragment_to_viewResponseFragment);
    }
}
