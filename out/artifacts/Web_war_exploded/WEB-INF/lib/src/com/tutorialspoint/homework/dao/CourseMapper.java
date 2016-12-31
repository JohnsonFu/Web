package com.tutorialspoint.homework.dao;

import com.tutorialspoint.homework.bean.Course;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/31.
 */
public interface CourseMapper {
    public void addCourse( Course course );

    public List<Course> getCourseList ();

    public void deleteCourse ( int id );
}
