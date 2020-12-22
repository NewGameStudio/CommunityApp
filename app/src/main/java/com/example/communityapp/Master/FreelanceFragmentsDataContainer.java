package com.example.communityapp.Master;

import com.example.communityapp.Entities.FreelanceTask;

public class FreelanceFragmentsDataContainer {

    private static FreelanceTask currentViewFreelanceTask;
    private static FreelanceTask currentCreatingFreelanceTask;

    public static FreelanceTask getCurrentViewFreelanceTask() {
        return currentViewFreelanceTask;
    }

    public static void setCurrentViewFreelanceTask(FreelanceTask currentViewFreelanceTask) {
        FreelanceFragmentsDataContainer.currentViewFreelanceTask = currentViewFreelanceTask;
    }

    public static FreelanceTask getCurrentCreatingFreelanceTask() {
        return currentCreatingFreelanceTask;
    }

    public static void setCurrentCreatingFreelanceTask(FreelanceTask currentCreatingFreelanceTask) {
        FreelanceFragmentsDataContainer.currentCreatingFreelanceTask = currentCreatingFreelanceTask;
    }
}
