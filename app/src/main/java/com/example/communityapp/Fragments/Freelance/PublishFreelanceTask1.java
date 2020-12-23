package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.communityapp.Controllers.ClassController;
import com.example.communityapp.Controllers.SubjectsController;
import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

import java.util.List;

public class PublishFreelanceTask1 extends Fragment
        implements View.OnClickListener {

    private Spinner classSpinner;
    private Spinner subjectSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_publish_freelance_task1, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        configureClassSpinner();
        configureSubjectSpinner();

        Button nextButton = getView().findViewById(R.id.next_btn);
        nextButton.setOnClickListener(this);
    }

    protected void configureClassSpinner() {
        classSpinner = getView().findViewById(R.id.class_spinner);
        classSpinner.setPrompt("Класс");

        List<String> classNames = ClassController.findAllClasses();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, classNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        classSpinner.setAdapter(adapter);
    }

    protected void configureSubjectSpinner() {
        subjectSpinner = getView().findViewById(R.id.subject_spinner);
        subjectSpinner.setPrompt("Предмет");

        List<String> subjects = SubjectsController.findAllSubjects();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, subjects);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        subjectSpinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.next_btn) {

            String subject = SubjectsController
                    .findSubjectById(subjectSpinner.getSelectedItemPosition());

            FreelanceTask taskEntity = FreelanceFragmentsDataContainer.getCurrentCreatingFreelanceTask();

            taskEntity.setClassIndex(classSpinner.getSelectedItemPosition() + 1);
            taskEntity.setSubjectName(subject);

            FreelanceFragmentsDataContainer.setCurrentCreatingFreelanceTask(taskEntity);

            NavigationMaster.navigate(getView(), R.id.action_publishFreelanceTask1_to_publishFreelanceTask2);
        }
    }
}