package com.example.communityapp.Entities;

public class TextbookTaskSolution extends BaseEntity{

    private int textbookTaskId;
    private int executorId;
    private String text;
    private int score;

    public int getTextbookTaskId() {
        return textbookTaskId;
    }

    public void setTextbookTaskId(int textbookTaskId) {
        this.textbookTaskId = textbookTaskId;
    }

    public int getExecutorId() {
        return executorId;
    }

    public void setExecutorId(int executorId) {
        this.executorId = executorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
