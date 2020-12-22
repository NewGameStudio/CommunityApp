package com.example.communityapp.Entities;

import java.util.Date;

public class Review extends BaseEntity {

    private int ownerId;
    private int employeeId;
    private String reviewText;
    private Date publicationDate;
    private int score;

    public Review(int ownerId, int employeeId) {
        this.ownerId = ownerId;
        this.employeeId = employeeId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
