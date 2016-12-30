package com.tutorialspoint.homework.bean;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class Course {
    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    private int id;
    private String name;
}
