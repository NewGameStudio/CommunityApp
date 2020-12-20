package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.communityapp.Adapter.FreelanceTaskAdapter;
import com.example.communityapp.Controllers.FreelanceTasksController;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.Handlers.OnClickItemListener;
import com.example.communityapp.Master.DataMaster;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

import java.util.ArrayList;
import java.util.List;

public class FreelanceFragment extends Fragment
        implements OnClickItemListener, View.OnClickListener {

    private RecyclerView tasksRecycler;
    private List<FreelanceTaskEntity> freelanceTasks;
    private int tabIndex = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_freelance, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.filter_btn).setVisible(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.filter_btn:
                NavigationMaster.navigate(getView(),
                        R.id.action_nav_freelance_to_searchTasksFilterFragment);
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        tasksRecycler = getView().findViewById(R.id.freelance_tasks_recycler_view);
        tasksRecycler.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        tasksRecycler.setLayoutManager(layoutManager);

        onFreelanceTasksSearchSelected();

        Button searchTasksButton = getView().findViewById(R.id.search_task_btn);
        Button myTasksButton = getView().findViewById(R.id.my_task_btn);
        Button newTaskButton = getView().findViewById(R.id.new_task_btn);

        searchTasksButton.setOnClickListener(this);
        myTasksButton.setOnClickListener(this);
        newTaskButton.setOnClickListener(this);
    }

    private void onFreelanceTasksSearchSelected() {
        freelanceTasks = FreelanceTasksController.findAvailableTasks();

        getView().findViewById(R.id.new_task_btn).setVisibility(View.INVISIBLE);

        RecyclerView.Adapter recyclerAdapter = new FreelanceTaskAdapter(freelanceTasks,
                this);

        tasksRecycler.setAdapter(recyclerAdapter);

        tabIndex = 0;
    }

    private void onFreelanceMyTasksSelected() {
        freelanceTasks = new ArrayList<>();

        getView().findViewById(R.id.new_task_btn).setVisibility(View.VISIBLE);

        freelanceTasks.addAll(FreelanceTasksController.findExecutableTasks());
        freelanceTasks.addAll(FreelanceTasksController.findPublishedTasks());

        RecyclerView.Adapter recyclerAdapter = new FreelanceTaskAdapter(freelanceTasks,
                this);

        tasksRecycler.setAdapter(recyclerAdapter);

        tabIndex = 1;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.search_task_btn)
            onFreelanceTasksSearchSelected();

        else if(view.getId() == R.id.my_task_btn)
            onFreelanceMyTasksSelected();

        else if(view.getId() == R.id.new_task_btn)
            NavigationMaster.navigate(getView(),
                    R.id.action_nav_freelance_to_publishFreelanceTask1);
    }

    @Override
    public void onItemClick(int itemIndex) {

        if(freelanceTasks.get(itemIndex).getTaskOwner().getId() == UserController.getUser().getId())
            return;

        DataMaster.setCurrentFreelanceTask(freelanceTasks.get(itemIndex));
        NavigationMaster.navigate(getView(),
                R.id.action_nav_freelance_to_freelancerTaskViewFragment);
    }
}