package com.example.communityapp.Entities;

import com.example.communityapp.Utils.DateUtil;

import java.util.Date;

public class FreelanceTaskEntity {

    public String title;
    public int price;
    public int classIndex;
    public String subjectName;
    public Date publicationDate;
    public Date expirationDate;
    public UserEntity taskOwner;

    public int expirationDaysLeft() {
        return DateUtil.daysBetween(publicationDate, expirationDate);
    }
}
