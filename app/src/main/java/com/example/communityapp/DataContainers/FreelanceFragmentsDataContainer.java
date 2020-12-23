package com.example.communityapp.DataContainers;

import com.example.communityapp.Entities.FreelanceTask;
import com.example.communityapp.Entities.Response;

public class FreelanceFragmentsDataContainer {

    private static FreelanceTask currentViewFreelanceTask;
    private static FreelanceTask currentCreatingFreelanceTask;
    private static Response currentViewResponse;

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

    public static Response getCurrentViewResponse() {
        return currentViewResponse;
    }

    public static void setCurrentViewResponse(Response currentViewResponse) {
        FreelanceFragmentsDataContainer.currentViewResponse = currentViewResponse;
    }
}
