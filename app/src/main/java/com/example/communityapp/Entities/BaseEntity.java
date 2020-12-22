package com.example.communityapp.Entities;

public class BaseEntity {

    private static int nextId = 0;
    private int id = -1;

    public int getId() {
        if(id == -1)
            id = nextId++;

        return id;
    }
}
