package com.example.communityapp.Controllers;

import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.Utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class FreelanceTasksController {

    public static List<FreelanceTaskEntity> findAvailableTasks() {

        FreelanceTaskEntity task1 = new FreelanceTaskEntity();
        task1.setTitle("Сочинение по русскому");
        task1.setPrice(300);
        task1.setClassIndex(10);
        task1.setSubjectName("Русский язык");
        task1.setPublicationDate(DateUtil.toDateStandard("20.01.2020"));
        task1.setExpirationDate(DateUtil.toDateStandard("11.12.2020"));

        FreelanceTaskEntity task2 = new FreelanceTaskEntity();
        task2.setTitle("Сочинение по математике");
        task2.setPrice(500);
        task2.setClassIndex(9);
        task2.setSubjectName("Математика");
        task2.setPublicationDate(DateUtil.toDateStandard("25.02.2020"));
        task2.setExpirationDate(DateUtil.toDateStandard("01.03.2020"));

        ArrayList<FreelanceTaskEntity> freelanceTasks = new ArrayList<>();
        freelanceTasks.add(task1);
        freelanceTasks.add(task2);

        return freelanceTasks;
    }
}
