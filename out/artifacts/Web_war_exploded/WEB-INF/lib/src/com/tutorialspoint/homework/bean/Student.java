package com.tutorialspoint.homework.bean;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class Student {
    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    private long id=100000;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    private String name;
    private String password;
    private List<StudentCourse> courses;

    public List<StudentCourse> getCourses () {
        return courses;
    }

    public void setCourses ( List<StudentCourse> courses ) {
        this.courses = courses;
    }
}
