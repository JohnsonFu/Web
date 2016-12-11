package com.tutorialspoint.homework.action;

import com.tutorialspoint.homework.Service.TeacherService;
import com.tutorialspoint.homework.bean.Course;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class TeacherAction {
    public Course getCourse () {
        return course;
    }

    public void setCourse ( Course course ) {
        this.course = course;
    }

    private Course course=new Course();
    public TeacherService getService () {
        return service;
    }

    public void setService ( TeacherService service ) {
        this.service = service;
    }

    private TeacherService service;

    public List<Course> getCourselist () {
        return courselist;
    }

    public void setCourselist ( List<Course> courselist ) {
        this.courselist = courselist;
    }

    private List<Course> courselist;
    public String addCourse(){
        service.add(course);
        courselist=service.getList();
        return "CourseList";
    }

    public String getList(){
        courselist=service.getList();
        return "CourseList";
    }
    public String remove(){
        service.deleteCourse(course.getId());
        courselist=service.getList();
        return "CourseList";
    }

}
