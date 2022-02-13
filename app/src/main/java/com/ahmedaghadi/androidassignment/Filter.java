package com.ahmedaghadi.androidassignment;

public class Filter {
    private String name;
    private int count;
    private int id;


    public Filter(int id, String name, int count) {
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
