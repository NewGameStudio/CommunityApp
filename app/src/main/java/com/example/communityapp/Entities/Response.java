package com.example.communityapp.Entities;

import java.util.Date;

public class Response extends BaseEntity {

    private int taskId;
    private int ownerId;
    private String description;
    private Date completionDate;
    private int price;

    public Response(int ownerId, int taskId) {
        this.ownerId = ownerId;
        this.taskId = taskId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
