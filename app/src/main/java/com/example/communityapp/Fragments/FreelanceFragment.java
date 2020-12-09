package com.example.communityapp.Fragments;

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
        task1.title = "Сочинение по русскому";
        task1.price = 300;
        task1.classIndex = 10;
        task1.publicationDate = "20.01.20";
        task1.expirationDate = "11.12.20";

        FreelanceTaskEntity task2 = new FreelanceTaskEntity();
        task2.title = "Калькулятор на c++";
        task2.price = 500;
        task2.classIndex = 8;
        task2.publicationDate = "17.05.20";
        task2.expirationDate = "11.12.20";

        FreelanceTaskEntity task3 = new FreelanceTaskEntity();
        task3.title = "Доклад по истории";
        task3.price = 1000;
        task3.classIndex = 9;
        task3.publicationDate = "03.07.20";
        task3.expirationDate = "11.12.20";

        ArrayList<FreelanceTaskEntity> freelanceTasks = new ArrayList<>();
        freelanceTasks.add(task1);
        freelanceTasks.add(task2);
        freelanceTasks.add(task3);
        freelanceTasks.add(task1);
        freelanceTasks.add(task2);
        freelanceTasks.add(task3);
        freelanceTasks.add(task1);
        freelanceTasks.add(task2);
        freelanceTasks.add(task3);

        searchTaskRecycler = getActivity().findViewById(R.id.freelance_tasks_recycler_view);
        searchTaskRecycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        searchTaskAdapter = new FreelanceTaskAdapter(freelanceTasks);

        searchTaskRecycler.setLayoutManager(layoutManager);
        searchTaskRecycler.setAdapter(searchTaskAdapter);
    }
}