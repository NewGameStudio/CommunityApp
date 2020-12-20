package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.Master.DataMaster;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

public class PublishFreelanceTask1 extends Fragment
        implements View.OnClickListener {

    private String[] classNames = {
            "Первый", "Второй", "Третий",
            "Четвертый", "Пятый", "Шестой", "Восьмой",
            "Девятый", "Десятый", "Одиннадцатый"
    };

    private String[] subjects = { "Математика", "Русский язык", "История",
            "Иностранный язык", "Алгебра", "Геометрия", "Биология",
            "Информатика", "Другое"
    };

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
        Spinner spinner = getView().findViewById(R.id.class_spinner);
        spinner.setPrompt("Класс");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, classNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    protected void configureSubjectSpinner() {
        Spinner spinner = getView().findViewById(R.id.subject_spinner);
        spinner.setPrompt("Предмет");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, subjects);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.next_btn) {
            Spinner classSpinner = getView().findViewById(R.id.class_spinner);
            Spinner subjectSpinner = getView().findViewById(R.id.subject_spinner);

            String subject = subjects[subjectSpinner.getSelectedItemPosition()];

            FreelanceTaskEntity taskEntity = DataMaster.getCurrentCreatingFreelanceTask();

            taskEntity.setClassIndex(classSpinner.getSelectedItemPosition() + 1);
            taskEntity.setSubjectName(subject);

            DataMaster.setCurrentCreatingFreelanceTask(taskEntity);

            NavigationMaster.navigate(getView(), R.id.action_publishFreelanceTask1_to_publishFreelanceTask2);
        }
    }
}