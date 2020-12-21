package com.example.communityapp.Entities;

public class TaskEntity {
    public int number;
    public boolean solved;
    public int solved_number;

    public TaskEntity(int number, boolean solved, int solved_number){
        this.number = number;
        this.solved = solved;
        this.solved_number = solved_number;
    }
}
