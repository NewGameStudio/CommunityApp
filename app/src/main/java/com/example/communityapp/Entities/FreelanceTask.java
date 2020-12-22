package com.example.communityapp.Entities;

import com.example.communityapp.Utils.DateUtil;

import java.util.Date;
import java.util.List;

public class FreelanceTask extends BaseEntity {

    private String title;
    private String description;
    private int price;
    private int classIndex;
    private String subjectName;
    private Date publicationDate;
    private Date expirationDate;

    private int taskOwnerId;
    private int taskExecutorId;
    private List<Integer> responsesIDs;
    private int responsesCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getTaskOwnerId() {
        return taskOwnerId;
    }

    public void setTaskOwnerId(int taskOwnerId) {
        this.taskOwnerId = taskOwnerId;
    }

    public int getTaskExecutorId() {
        return taskExecutorId;
    }

    public void setTaskExecutorId(int taskExecutorId) {
        this.taskExecutorId = taskExecutorId;
    }

    public List<Integer> getResponsesIDs() {
        return responsesIDs;
    }

    public void setResponsesIDs(List<Integer> responsesIDs) {
        this.responsesIDs = responsesIDs;
    }

    public int getResponsesCount() {
        return responsesCount;
    }

    public void setResponsesCount(int responsesCount) {
        this.responsesCount = responsesCount;
    }
}
