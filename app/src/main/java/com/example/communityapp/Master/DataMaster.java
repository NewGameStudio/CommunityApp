package com.example.communityapp.Master;

import com.example.communityapp.Entities.FreelanceTaskEntity;

public class DataMaster {

    private static FreelanceTaskEntity currentFreelanceTask;

    public static FreelanceTaskEntity getCurrentFreelanceTask() {
        return currentFreelanceTask;
    }

    public static void setCurrentFreelanceTask(FreelanceTaskEntity currentFreelanceTask) {
        DataMaster.currentFreelanceTask = currentFreelanceTask;
    }
}
