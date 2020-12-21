package com.example.communityapp.Fragments.Gdz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.communityapp.Controllers.ClassController;
import com.example.communityapp.Controllers.SubjectsController;
import com.example.communityapp.R;

import java.util.List;

public class SearchTextbookFilterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_textbook_filter, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        configureClassSpinner();
        configureSubjectSpinner();
    }

    protected void configureClassSpinner() {
        Spinner spinner = getView().findViewById(R.id.class_spinner);
        spinner.setPrompt("Класс");

        List<String> classNames = ClassController.findAllClasses();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, classNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    protected void configureSubjectSpinner() {
        Spinner spinner = getView().findViewById(R.id.subject_spinner);
        spinner.setPrompt("Предмет");

        List<String> subjects = SubjectsController.findAllSubjects();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, subjects);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
}
