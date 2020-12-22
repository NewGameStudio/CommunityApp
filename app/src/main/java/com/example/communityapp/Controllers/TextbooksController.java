package com.example.communityapp.Controllers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.example.communityapp.Entities.Textbook;
import com.example.communityapp.MainActivity;
import com.example.communityapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextbooksController {

    private static List<Textbook> textbooksList;

    //TODO delete this
    public static void init() {

        Activity activity = MainActivity.getMainActivity();
        Bitmap textbookCover = BitmapFactory.decodeResource(activity.getResources(),
                R.drawable.book_cover);

        Textbook textbook1 = new Textbook();
        textbook1.setId(1);
        textbook1.setTextbookTitle("Физика 10 класс");
        textbook1.setTextbookCover(textbookCover);
        textbook1.setAuthors(new ArrayList<String>(Arrays.asList("Мякишев", "Буховцева")));
        textbook1.setClassIndex(10);
        textbook1.setSubjectName("Физика");

        textbooksList = new ArrayList<>();
        textbooksList.add(textbook1);
    }

    public static List<Textbook> findAllTextbooks() {
        return textbooksList;
    }

    public static List<Textbook> findTextbooks(String subject, int classIndex) {

        Toast.makeText(MainActivity.getMainActivity(), Integer.toString(classIndex),
                Toast.LENGTH_SHORT).show();

        ArrayList<Textbook> textbooks = new ArrayList<>();

        for(Textbook textbook : textbooksList) {
            if(textbook.getClassIndex() != classIndex)
                continue;

            if(!textbook.getSubjectName().equals(subject))
                continue;

            textbooks.add(textbook);
        }

        return textbooks;
    }
}
