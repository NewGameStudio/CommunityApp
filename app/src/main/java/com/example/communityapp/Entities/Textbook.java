package com.example.communityapp.Entities;

import android.graphics.Bitmap;

import java.util.List;

public class Textbook extends BaseEntity {

    private String textbookTitle;
    private Bitmap textbookCover;
    private List<String> authors;
    private int classIndex;
    private String subjectName;

    public String getTextbookTitle() {
        return textbookTitle;
    }

    public void setTextbookTitle(String textbookTitle) {
        this.textbookTitle = textbookTitle;
    }

    public Bitmap getTextbookCover() {
        return textbookCover;
    }

    public void setTextbookCover(Bitmap textbookCover) {
        this.textbookCover = textbookCover;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
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
}
