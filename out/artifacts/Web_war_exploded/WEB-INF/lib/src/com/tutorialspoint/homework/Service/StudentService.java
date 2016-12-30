package com.tutorialspoint.homework.Service;

import com.tutorialspoint.homework.bean.Course;
import com.tutorialspoint.homework.bean.Student;
import com.tutorialspoint.homework.bean.StudentCourse;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/11.
 */
public interface StudentService {


  public  void regist ( Student student );

   public String login ( Student student );

  public  void addCourse ( Student student, Course course );

   public  List<Course> getCourseList ();

  public   List<StudentCourse> getMyCourses ( Student student );
}
