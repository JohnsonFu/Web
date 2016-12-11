package com.tutorialspoint.homework.bean;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class StudentCourse {
    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public int getCourseid () {
        return courseid;
    }

    public void setCourseid ( int courseid ) {
        this.courseid = courseid;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    private int id;
    private int courseid;
    private String name;

    public boolean isHasExam () {
        return hasExam;
    }

    public void setHasExam ( boolean hasExam ) {
        this.hasExam = hasExam;
    }

    private boolean hasExam=false;

}
