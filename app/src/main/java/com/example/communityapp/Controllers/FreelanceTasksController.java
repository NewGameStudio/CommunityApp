package com.example.communityapp.Controllers;

import android.widget.Toast;

import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.Entities.Response;
import com.example.communityapp.Entities.User;
import com.example.communityapp.MainActivity;
import com.example.communityapp.Utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class FreelanceTasksController {

    private static List<FreelanceTask> freelanceTasks = new ArrayList<>();
    private static List<Response> responses = new ArrayList<>();

    //TODO delete this
    public static void init() {

        FreelanceTask task1 = new FreelanceTask(UserController.findUserByName("admin").getId());
        task1.setTitle("Сочинение по русскому");
        task1.setDescription("Требуется разработать полный дизайн-проект \n" +
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
        task1.setPrice(300);
        task1.setClassIndex(10);
        task1.setSubjectName("Русский язык");
        task1.setPublicationDate(DateUtil.toDateStandard("20.01.2020"));
        task1.setExpirationDate(DateUtil.toDateStandard("11.12.2020"));

        FreelanceTask task2 = new FreelanceTask(UserController.findUserByName("admin2").getId());
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

        FreelanceTask task3 = new FreelanceTask(UserController.findUserByName("Дима Шелохвостов").getId());
        task3.setTitle("Сочинение по географии");
        task3.setDescription("Написать сочинение по географии, плачу много");
        task3.setPrice(1000);
        task3.setClassIndex(10);
        task3.setSubjectName("География");
        task3.setPublicationDate(DateUtil.toDateStandard("20.01.2020"));
        task3.setExpirationDate(DateUtil.toDateStandard("11.12.2020"));

        freelanceTasks.add(task1);
        freelanceTasks.add(task2);
        freelanceTasks.add(task3);
    }

    public static FreelanceTask findTaskById(int id) {
        for (FreelanceTask task : freelanceTasks) {
            if(task.getId() == id)
                return task;
        }

        return null;
    }

    public static List<FreelanceTask> findAvailableTasks() {
        return freelanceTasks;
    }

    public static List<FreelanceTask> findExecutableTasks() {
        ArrayList<FreelanceTask> tasks = new ArrayList<>();

        for(int i = 0; i < freelanceTasks.size(); i++) {
            User taskExecutor = UserController
                    .findUserById(freelanceTasks.get(i).getTaskExecutorId());

            if(taskExecutor != null) {
                if (taskExecutor.getId() == UserController.getUser().getId())
                    tasks.add(freelanceTasks.get(i));
            }
        }

        return tasks;
    }

    public static List<FreelanceTask> findPublishedTasks() {
        ArrayList<FreelanceTask> tasks = new ArrayList<>();

        for(int i = 0; i < freelanceTasks.size(); i++) {

            User taskOwner = UserController
                    .findUserById(freelanceTasks.get(i).getTaskOwnerId());

            if(taskOwner.getId() == UserController.getUser().getId())
                tasks.add(freelanceTasks.get(i));
        }

        return tasks;
    }

    public static void publishNewTask(FreelanceTask taskEntity) {
        freelanceTasks.add(taskEntity);
    }

    public static void respondToTask(int taskId, Response response) {

        FreelanceTask task = findTaskById(taskId);

        if(task == null) {
            Toast.makeText(MainActivity.getMainActivity(),
                    "Задача не найдена, где-то ты обосрался", Toast.LENGTH_SHORT).show();
            return;
        }

        responses.add(response);

        List<Integer> responsesIDs = task.getResponsesIDs();
        responsesIDs.add(response.getId());

        task.setResponsesIDs(responsesIDs);
    }
}
