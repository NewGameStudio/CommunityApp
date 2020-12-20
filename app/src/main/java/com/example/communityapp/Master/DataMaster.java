package com.example.communityapp.Master;

import com.example.communityapp.Entities.FreelanceTaskEntity;

public class DataMaster {

    private static FreelanceTaskEntity currentFreelanceViewTask;
    private static FreelanceTaskEntity currentCreatingFreelanceTask;

    public static FreelanceTaskEntity getCurrentFreelanceViewTask() {
        return currentFreelanceViewTask;
    }

    public static void setCurrentFreelanceViewTask(FreelanceTaskEntity currentFreelanceViewTask) {
        DataMaster.currentFreelanceViewTask = currentFreelanceViewTask;
    }

    public static FreelanceTaskEntity getCurrentCreatingFreelanceTask() {
        return currentCreatingFreelanceTask;
    }

    public static void setCurrentCreatingFreelanceTask(FreelanceTaskEntity currentCreatingFreelanceTask) {
        DataMaster.currentCreatingFreelanceTask = currentCreatingFreelanceTask;
    }
}
