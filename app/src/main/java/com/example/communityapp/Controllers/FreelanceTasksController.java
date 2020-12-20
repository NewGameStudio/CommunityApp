package com.example.communityapp.Controllers;

import android.graphics.BitmapFactory;

import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.Entities.UserEntity;
import com.example.communityapp.Utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class FreelanceTasksController {

    public static List<FreelanceTaskEntity> findAvailableTasks() {

        UserEntity user1 = new UserEntity();
        user1.setUsername("Дима Шелохвостов");
        user1.setDescription("Дебик");

        UserEntity user2 = new UserEntity();
        user2.setUsername("Отец Даниил");
        user2.setDescription("Не дебик");

        FreelanceTaskEntity task1 = new FreelanceTaskEntity();
        task1.setTitle("Сочинение по русскому");
        task1.setDescription("Я покакал");
        task1.setPrice(300);
        task1.setClassIndex(10);
        task1.setSubjectName("Русский язык");
        task1.setPublicationDate(DateUtil.toDateStandard("20.01.2020"));
        task1.setExpirationDate(DateUtil.toDateStandard("11.12.2020"));
        task1.setResponsesCount(5);
        task1.setTaskOwner(user1);

        FreelanceTaskEntity task2 = new FreelanceTaskEntity();
        task2.setTitle("Сочинение по математике");
        task2.setDescription("Требуется разработать полный дизайн-проект \n" +
                "дома из клееного бруса в современном стиле.\n" +
                "Состав проекта ниже. \n" +
                "Без опыта с домами из клееного бруса не \n" +
                "обращайтесь. Присылайте примеры \n" +
                "выполненных работ домов в клееном брусе.\n" +
                "\n" +
                "СОСТАВ ПРОЕКТА: \n" +
                "\n" +
                "Раздел 1: \n" +
                "-план организации пространства с указанием \n" +
                "наименований помещений и их площадей\n" +
                "Раздел 2: \n" +
                "-принципиальная схема силовой и слаботочной\n" +
                " электросетей;\n");
        task2.setPrice(500);
        task2.setClassIndex(9);
        task2.setSubjectName("Математика");
        task2.setPublicationDate(DateUtil.toDateStandard("25.02.2020"));
        task2.setExpirationDate(DateUtil.toDateStandard("01.03.2020"));
        task2.setTaskOwner(user2);

        ArrayList<FreelanceTaskEntity> freelanceTasks = new ArrayList<>();
        freelanceTasks.add(task1);
        freelanceTasks.add(task2);

        return freelanceTasks;
    }
}
