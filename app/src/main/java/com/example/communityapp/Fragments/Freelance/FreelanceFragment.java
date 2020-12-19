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

import com.example.communityapp.Adapter.FreelanceTaskAdapter;
import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

import java.util.ArrayList;

public class FreelanceFragment extends Fragment {

    private RecyclerView searchTaskRecycler;
    private RecyclerView.Adapter searchTaskAdapter;
    private RecyclerView.LayoutManager layoutManager;


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

        FreelanceTaskEntity task1 = new FreelanceTaskEntity();
        task1.setTitle("Сочинение по русскому");
        task1.setPrice(300);
        task1.setClassIndex(10);
        task1.setPublicationDate(DateUtil.toDateStandard("20.01.20"));
        task1.setExpirationDate(DateUtil.toDateStandard("11.12.20"));

        ArrayList<FreelanceTaskEntity> freelanceTasks = new ArrayList<>();
        freelanceTasks.add(task1);
        freelanceTasks.add(task1);
        freelanceTasks.add(task1);
        freelanceTasks.add(task1);
        freelanceTasks.add(task1);
        freelanceTasks.add(task1);

        searchTaskRecycler = getActivity().findViewById(R.id.freelance_tasks_recycler_view);
        searchTaskRecycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        searchTaskAdapter = new FreelanceTaskAdapter(freelanceTasks);

        searchTaskRecycler.setLayoutManager(layoutManager);
        searchTaskRecycler.setAdapter(searchTaskAdapter);
    }
}