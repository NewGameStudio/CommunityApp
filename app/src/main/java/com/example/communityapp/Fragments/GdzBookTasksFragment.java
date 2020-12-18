package com.example.communityapp.Fragments;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.communityapp.Adapter.GDZBookAdapter;
import com.example.communityapp.Entities.BookEntity;
import com.example.communityapp.Entities.TaskEntity;
import com.example.communityapp.R;

import java.util.ArrayList;

public class GdzBookTasksFragment extends Fragment {

    private LinearLayout linearLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

//        linearLayout = (LinearLayout) getActivity().findViewById(R.id.linearLayout);
//        Button b = new Button(getApplicationContext());
//        b.setText("Удалить данную кнопку №" + Integer.toString(countID + 1));
//        b.setLayoutParams(
//                new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT)
//        );
//        b.setId(USERID + countID);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                linearLayout.removeView(v);
//            }
//        });
//        linearLayout.addView(b);
//        countID++;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gdz_book_tasks, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        linearLayout = getActivity().findViewById(R.id.gdz_book_tasks_layout);
        String[] categories  = {"Глава 1", "Глава 2", "Глава 3", "Глава 4", "Глава 1", "Глава 2", "Глава 3", "Глава 4", "Глава 1", "Глава 2", "Глава 3", "Глава 4", "Глава 1", "Глава 2", "Глава 3", "Глава 4"};


        for (String category : categories)
        {
            final float scale = getContext().getResources().getDisplayMetrics().density;

            //categoryLayout
            LinearLayout categoryLayout = new LinearLayout(getActivity().getApplicationContext());

            LinearLayout.LayoutParams categoryLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
//            int categoryLayoutVerticalPixels = (int) (10 * scale + 0.5f);
//            int categoryLayoutHorizontalPixels = (int) (14 * scale + 0.5f);
//            categoryLayoutParams.setMargins(0, categoryLayoutVerticalPixels, 0, categoryLayoutVerticalPixels);
            categoryLayout.setLayoutParams(categoryLayoutParams);
            categoryLayout.setOrientation(LinearLayout.VERTICAL);
//            int taskSolveVerticalPixelsPadding = (int) (10 * scale + 0.5f);
//            categoryLayout.setPadding(0, 0, 0, 0);

            //categoryDescr
            TextView categoryDescription = new TextView(getActivity().getApplicationContext());

            int textViewHeightPixels = (int) (35 * scale + 0.5f);
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    textViewHeightPixels
            );

            int textViewVerticalPixels = (int) (10 * scale + 0.5f);
            int textViewHorizontalPixels = (int) (14 * scale + 0.5f);
            textParams.setMargins(textViewHorizontalPixels, textViewVerticalPixels, textViewHorizontalPixels, 0);
            categoryDescription.setLayoutParams(textParams);

            categoryDescription.setBackgroundResource(R.drawable.shape_rectangle);
            categoryDescription.setBackgroundColor(getResources().getColor(R.color.colorLightGrey));
            categoryDescription.setBackgroundTintMode(PorterDuff.Mode.ADD);
            categoryDescription.setGravity(Gravity.CENTER);
            categoryDescription.setText(category);
            categoryDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            categoryDescription.setTextColor(getResources().getColor(R.color.colorBlack));
            categoryDescription.setTypeface(categoryDescription.getTypeface(), Typeface.BOLD);

            categoryLayout.addView(categoryDescription);

            TaskEntity[] tasks  = {
                    new TaskEntity(139, true, 7),
                    new TaskEntity(140, false, 0),
                    new TaskEntity(141, false, 0),
                    new TaskEntity(142, true, 10)};

            for (TaskEntity task : tasks){
                createTask(task.number, task.solved, task.solved_number, categoryLayout, scale);
            }

            linearLayout.addView(categoryLayout);
        }

    }

    public void createTask(int number, boolean solved, int solved_number, LinearLayout mainLayout, float scale) {
        //Layout
        LinearLayout taskLayout = new LinearLayout(getActivity().getApplicationContext());
        LinearLayout.LayoutParams taskLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int taskLayoutTopPixels = (int) (10 * scale + 0.5f);
        int taskLayoutHorizontalPixels = (int) (14 * scale + 0.5f);
        taskLayoutParams.setMargins(taskLayoutHorizontalPixels, taskLayoutTopPixels, taskLayoutHorizontalPixels, 0);
        taskLayout.setLayoutParams(taskLayoutParams);

        int taskLayoutZ = (int) (4 * scale + 0.5f);
        taskLayout.setTranslationZ(taskLayoutZ);
        taskLayout.setOrientation(LinearLayout.VERTICAL);
        taskLayout.setBackgroundResource(R.drawable.shape_rectangle);
        taskLayout.setBackgroundColor(getResources().getColor(R.color.white));
        taskLayout.setBackgroundTintMode(PorterDuff.Mode.ADD);


        //TextView
        TextView taskDescription = new TextView(getActivity().getApplicationContext());

        LinearLayout.LayoutParams taskDescriptionParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        int taskDescriptionVerticalPixels = (int) (10 * scale + 0.5f);
        int taskDescriptionHorizontalPixels = (int) (13 * scale + 0.5f);
        taskDescriptionParams.setMargins(taskDescriptionHorizontalPixels, taskDescriptionVerticalPixels, taskDescriptionHorizontalPixels, taskDescriptionVerticalPixels);
        taskDescription.setLayoutParams(taskDescriptionParams);
        taskDescription.setGravity(Gravity.CENTER);
        taskDescription.setText("Номер задания: " + number);
        taskDescription.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        taskDescription.setTextColor(getResources().getColor(R.color.colorDarkBlack));
        taskDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        taskDescription.setTypeface(taskDescription.getTypeface(), Typeface.BOLD);

        taskLayout.addView(taskDescription);

        //subLinearLayout
        LinearLayout subTaskLayout = new LinearLayout(getActivity().getApplicationContext());
        LinearLayout.LayoutParams subTaskLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int subTaskLayoutVerticalPixels = (int) (10 * scale + 0.5f);
        int subTaskLayoutHorizontalPixels = (int) (13 * scale + 0.5f);
        subTaskLayoutParams.setMargins(subTaskLayoutHorizontalPixels, subTaskLayoutVerticalPixels, subTaskLayoutHorizontalPixels, subTaskLayoutVerticalPixels);
        subTaskLayout.setLayoutParams(subTaskLayoutParams);
        subTaskLayout.setOrientation(LinearLayout.HORIZONTAL);

        taskLayout.addView(subTaskLayout);

        //taskSolveDescription
        TextView taskSolveDescription = new TextView(getActivity().getApplicationContext());

        int taskSolveDescriptionWidthPixels = (int) (0 * scale + 0.5f);
        LinearLayout.LayoutParams taskSolveParams = new LinearLayout.LayoutParams(
                taskSolveDescriptionWidthPixels,
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.2f
        );

//        int taskSolveVerticalPixels = (int) (10 * scale + 0.5f);
//        int taskSolveHorizontalPixels = (int) (13 * scale + 0.5f);
//        taskSolveParams.setMargins(taskSolveHorizontalPixels, taskSolveVerticalPixels, taskSolveHorizontalPixels, taskSolveVerticalPixels);
        taskSolveParams.gravity = Gravity.CENTER;
        taskSolveDescription.setLayoutParams(taskSolveParams);
        taskSolveDescription.setBackgroundResource(R.drawable.shape_rectangle);
//        taskSolveDescription.setBackgroundTintMode(PorterDuff.Mode.ADD);
        taskSolveDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//        taskSolveDescription.setGravity(Gravity.CENTER);

        if(solved){
            taskSolveDescription.setText("Решено");
            taskSolveDescription.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        else {
            taskSolveDescription.setText("Не решено");
            taskSolveDescription.setBackgroundColor(getResources().getColor(R.color.colorGrey));
        }

        taskSolveDescription.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        taskSolveDescription.setTextColor(getResources().getColor(R.color.colorBlack));

        int taskSolveVerticalPixelsPadding = (int) (5 * scale + 0.5f);
        int taskSolveHorizontalPixelsPadding = (int) (10 * scale + 0.5f);
        taskSolveDescription.setPadding(taskSolveHorizontalPixelsPadding, taskSolveVerticalPixelsPadding, taskSolveHorizontalPixelsPadding, taskSolveVerticalPixelsPadding);
        taskSolveDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        taskSolveDescription.setTypeface(taskSolveDescription.getTypeface(), Typeface.BOLD);
        taskSolveDescription.setTextColor(getResources().getColor(R.color.white));

        subTaskLayout.addView(taskSolveDescription);
//
//        if(solved) {
//            //ImageView
//            ImageView solveSectionImage = new ImageView(getActivity().getApplicationContext());
//
//            int solveSectionImagePixels = (int) (18 * scale + 0.5f);
//            LinearLayout.LayoutParams solveSectionImageParams = new LinearLayout.LayoutParams(
//                    solveSectionImagePixels,
//                    solveSectionImagePixels
//            );
//
//            int solveSectionImageMarginBottom = (int) (3 * scale + 0.5f);
//            solveSectionImageParams.setMargins(0, 0, 0, 0);
//            solveSectionImageParams.gravity = Gravity.CENTER;
//            solveSectionImage.setLayoutParams(solveSectionImageParams);
//            solveSectionImage.setImageResource(R.drawable.chat);
//
//            subTaskLayout.addView(solveSectionImage);
//
//            //SolvedText
//            TextView solvedText = new TextView(getActivity().getApplicationContext());
//
//            int solvedTextWidthPixels = (int) (0 * scale + 0.5f);
//            LinearLayout.LayoutParams solvedTextParams = new LinearLayout.LayoutParams(
//                    solvedTextWidthPixels,
//                    LinearLayout.LayoutParams.WRAP_CONTENT, 0.4f
//            );
//
//            int solvedTextMarginTop = (int) (10 * scale + 0.5f);
//            taskSolveParams.setMargins(0, solvedTextMarginTop,0, 0);
//            solvedText.setLayoutParams(solvedTextParams);
//            solvedText.setGravity(Gravity.START);
//            solvedText.setText("решений " + solved_number);
//            solvedText.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
//            solvedText.setTextColor(getResources().getColor(R.color.colorBlack));
//
//            int solvedTextVerticalPixelsPadding = (int) (5 * scale + 0.5f);
//            int solvedTextHorizontalPixelsPadding = (int) (5 * scale + 0.5f);
//            solvedText.setPadding(solvedTextHorizontalPixelsPadding, solvedTextVerticalPixelsPadding, solvedTextHorizontalPixelsPadding, solvedTextVerticalPixelsPadding);
//            solvedText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//            solvedText.setTextColor(getResources().getColor(R.color.colorDarkBlack));
//
//            subTaskLayout.addView(solvedText);
//        }

        mainLayout.addView(taskLayout);
    }
}