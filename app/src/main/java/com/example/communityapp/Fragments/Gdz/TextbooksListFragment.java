package com.example.communityapp.Fragments.Gdz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Adapter.TextbookAdapter;
import com.example.communityapp.Controllers.TextbooksController;
import com.example.communityapp.Entities.Textbook;
import com.example.communityapp.DataContainers.GdzFragmentsDataContainer;
import com.example.communityapp.R;

import java.util.List;

public class TextbooksListFragment extends Fragment {

    private RecyclerView textbooksRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_textbooks_list, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        textbooksRecycler = getView().findViewById(R.id.textbooks_recycler_view);
        textbooksRecycler.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        textbooksRecycler.setLayoutManager(layoutManager);

        showTextbooks();
    }

    private void showTextbooks() {
        int classIndex = GdzFragmentsDataContainer.getClassIndexFilter();
        String subject = GdzFragmentsDataContainer.getSubjectFilter();

        List<Textbook> textbooks = TextbooksController.findTextbooks(subject, classIndex);

        RecyclerView.Adapter recyclerAdapter = new TextbookAdapter(textbooks);

        textbooksRecycler.setAdapter(recyclerAdapter);
    }
}
