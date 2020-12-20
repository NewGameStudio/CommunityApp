package com.example.communityapp.Entities;

import com.example.communityapp.Utils.DateUtil;

import java.util.Date;

public class FreelanceTaskEntity {

    private String title;
    private int price;
    private int classIndex;
    private String subjectName;
    private Date publicationDate;
    private Date expirationDate;
    private UserEntity taskOwner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public UserEntity getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(UserEntity taskOwner) {
        this.taskOwner = taskOwner;
    }

    public long expirationDaysLeft() {
        return DateUtil.daysBetween(publicationDate, expirationDate);
    }
}
