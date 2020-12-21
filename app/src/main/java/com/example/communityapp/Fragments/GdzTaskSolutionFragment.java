package com.example.communityapp.Fragments;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.communityapp.Adapter.GDZBookAdapter;
import com.example.communityapp.Adapter.GdzTaskSolutionAdapter;
import com.example.communityapp.Entities.BookEntity;
import com.example.communityapp.Entities.TaskEntity;
import com.example.communityapp.Entities.TaskSolution;
import com.example.communityapp.Entities.UserEntity;
import com.example.communityapp.R;

import java.util.ArrayList;

public class GdzTaskSolutionFragment extends Fragment {

    private RecyclerView.Adapter solveAdapter;
    private RecyclerView solveRecycler;
    private RecyclerView.LayoutManager layoutManager;

    public GdzTaskSolutionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gdz_task_solution, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        UserEntity user1 = new UserEntity();
        user1.setUsername("Дима Шелохвостев");
        user1.setAvatarBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.blank_profile));

        TaskSolution solution1 = new TaskSolution();
        solution1.description = "Оаоаоа ммммм";
        solution1.rating = 50;
        solution1.taskOwner = user1;
//        solution1.taskRef = "Физика";

        UserEntity user2 = new UserEntity();
        user2.setUsername("Мади Лохошестов");
        user2.setAvatarBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.blank_profile));
        TaskSolution solution2 = new TaskSolution();
        solution2.description = "Оаоаоа ммммм";
        solution2.rating = 190;
        solution2.taskOwner = user2;

        UserEntity user3 = new UserEntity();
        user3.setUsername("Дрейан Кчераев");
        user3.setAvatarBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.blank_profile));
        TaskSolution solution3 = new TaskSolution();
        solution3.description = "Оаоаоа ммммм";
        solution3.rating = 1;
        solution3.taskOwner = user3;


        ArrayList<TaskSolution> taskSolutions = new ArrayList<>();
        taskSolutions.add(solution1);
        taskSolutions.add(solution2);
        taskSolutions.add(solution3);
        taskSolutions.add(solution2);
        taskSolutions.add(solution3);
        taskSolutions.add(solution2);
        taskSolutions.add(solution1);
        taskSolutions.add(solution2);

        layoutManager = new LinearLayoutManager(getActivity());
        solveAdapter = new GdzTaskSolutionAdapter(taskSolutions);

        solveRecycler = getActivity().findViewById(R.id.gdz_task_solution_recycler_view);
        solveRecycler.setLayoutManager(layoutManager);
        solveRecycler.setAdapter(solveAdapter);
    }
}