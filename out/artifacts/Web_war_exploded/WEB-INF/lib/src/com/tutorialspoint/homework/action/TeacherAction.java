package com.tutorialspoint.homework.action;

import com.tutorialspoint.homework.Service.TeacherService;
import com.tutorialspoint.homework.bean.Course;
import com.tutorialspoint.homework.dao.CourseMapper;

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

    public CourseMapper getCourseMapper () {
        return courseMapper;
    }

    public void setCourseMapper ( CourseMapper courseMapper ) {
        this.courseMapper = courseMapper;
    }

    private CourseMapper courseMapper;
    private List<Course> courselist;
    public String addCourse(){
      //  service.add(course);
       // courselist=service.getList();
        courseMapper.addCourse(course);
        courselist=courseMapper.getCourseList();
        return "CourseList";
    }

    public String getList(){
       // courselist=service.getList();
        courselist=courseMapper.getCourseList();
        return "CourseList";
    }
    public String remove(){
      //  service.deleteCourse(course.getId());
     //   courselist=service.getList();
        courseMapper.deleteCourse(course.getId());
        courselist=courseMapper.getCourseList();
        return "CourseList";
    }

}
