package com.example.communityapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.communityapp.R;

public class SearchTasksFilterFragment extends Fragment {

    private String[] classNames = {
            "Любой", "Первый", "Второй", "Третий",
            "Четвертый", "Пятый", "Шестой", "Восьмой",
            "Девятый", "Десятый", "Одиннадцатый"
    };

    private String[] subjects = {
            "Любой", "Математика", "Русский язык", "История",
            "Иностранный язык", "Алгебра", "Геометрия", "Биология",
            "Информатика"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_tasks_filter, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        configureClassFromSpinner();
        configureClassToSpinner();
        configureSubjectSpinner();
    }


    protected void configureClassFromSpinner() {
        Spinner spinner = getActivity().findViewById(R.id.class_from_filter_spinner);
        spinner.setPrompt("Класс от");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, classNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    protected void configureClassToSpinner() {
        Spinner spinner = getActivity().findViewById(R.id.class_to_filter_spinner);
        spinner.setPrompt("Класс до");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, classNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    protected void configureSubjectSpinner() {
        Spinner spinner = getActivity().findViewById(R.id.subject_filter_spinner);
        spinner.setPrompt("Предмет");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, subjects);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
}