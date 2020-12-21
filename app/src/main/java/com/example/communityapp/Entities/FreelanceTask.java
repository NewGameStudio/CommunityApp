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
    private int responsesCount;
    private User taskOwner;
    private List<User> responsesUsers;
    private User taskExecutor;

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

    public int getResponsesCount() {
        return responsesCount;
    }

    public void setResponsesCount(int responsesCount) {
        this.responsesCount = responsesCount;
    }

    public User getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(User taskOwner) {
        this.taskOwner = taskOwner;
    }

    public List<User> getResponsesUsers() {
        return responsesUsers;
    }

    public void setResponsesUsers(List<User> responsesUsers) {
        this.responsesUsers = responsesUsers;
    }

    public User getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(User taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public long expirationDaysLeft() {
        return DateUtil.daysBetween(publicationDate, expirationDate);
    }
}
