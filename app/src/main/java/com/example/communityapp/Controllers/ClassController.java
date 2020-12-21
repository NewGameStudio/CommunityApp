package com.example.communityapp.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassController {

    private static String[] classNames = {
            "Первый", "Второй", "Третий",
            "Четвертый", "Пятый", "Шестой", "Восьмой",
            "Девятый", "Десятый", "Одиннадцатый"
    };

    public static List<String> findAllClasses() {
        return new ArrayList<String>(Arrays.asList(classNames));
    }
}
