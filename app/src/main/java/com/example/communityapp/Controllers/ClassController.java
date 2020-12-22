package com.example.communityapp.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassController {

    private static List<String> classNames = new ArrayList<>(Arrays.asList(
            "Первый", "Второй", "Третий",
            "Четвертый", "Пятый", "Шестой", "Восьмой",
            "Девятый", "Десятый", "Одиннадцатый"));

    public static List<String> findAllClasses() {
        return classNames;
    }

    public static int getClassIndex(String className) {
        return classNames.indexOf(className) + 1;
    }
}
