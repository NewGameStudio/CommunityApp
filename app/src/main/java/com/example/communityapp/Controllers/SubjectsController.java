package com.example.communityapp.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubjectsController {

    private static String[] subjects = {
            "Математика", "Русский язык", "История",
            "Иностранный язык", "Алгебра", "Геометрия", "Биология",
            "Информатика", "Физика"
    };

    public static List<String> findAllSubjects() {
        return new ArrayList<>(Arrays.asList(subjects));
    }

    public static String findSubjectById(int id) {
        return subjects[id];
    }
}
