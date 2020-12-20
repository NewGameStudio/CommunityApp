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
import android.widget.Toast;

import com.example.communityapp.Adapter.FreelanceTaskAdapter;
import com.example.communityapp.Controllers.FreelanceTasksController;
import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.Handlers.OnClickItemListener;
import com.example.communityapp.Master.DataMaster;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

import java.util.List;

public class FreelanceFragment extends Fragment
        implements OnClickItemListener {

    private RecyclerView tasksRecycler;
    private List<FreelanceTaskEntity> freelanceTasks;

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
    }

    private void onFreelanceTasksSearchSelected() {
        freelanceTasks = FreelanceTasksController.findAvailableTasks();

        RecyclerView.Adapter searchTaskAdapter = new FreelanceTaskAdapter(freelanceTasks,
                this);

        tasksRecycler.setAdapter(searchTaskAdapter);
    }

    @Override
    public void onClick(int itemIndex) {
        DataMaster.setCurrentFreelanceTask(freelanceTasks.get(itemIndex));
        NavigationMaster.navigate(getView(),
                R.id.action_nav_freelance_to_freelancerTaskViewFragment);
    }
}