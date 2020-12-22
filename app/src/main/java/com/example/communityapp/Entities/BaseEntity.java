package com.example.communityapp.Entities;

public class BaseEntity {

    private static int nextId = 0;
    private int id = -1;

    public BaseEntity() {
        id = nextId++;
    }

    public int getId() {
        return id;
    }
}
