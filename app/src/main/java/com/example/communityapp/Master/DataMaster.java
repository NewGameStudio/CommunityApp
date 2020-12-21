package com.example.communityapp.Master;

import com.example.communityapp.Entities.FreelanceTask;

public class DataMaster {

    private static FreelanceTask currentFreelanceViewTask;
    private static FreelanceTask currentCreatingFreelanceTask;

    public static FreelanceTask getCurrentFreelanceViewTask() {
        return currentFreelanceViewTask;
    }

    public static void setCurrentFreelanceViewTask(FreelanceTask currentFreelanceViewTask) {
        DataMaster.currentFreelanceViewTask = currentFreelanceViewTask;
    }

    public static FreelanceTask getCurrentCreatingFreelanceTask() {
        return currentCreatingFreelanceTask;
    }

    public static void setCurrentCreatingFreelanceTask(FreelanceTask currentCreatingFreelanceTask) {
        DataMaster.currentCreatingFreelanceTask = currentCreatingFreelanceTask;
    }
}
