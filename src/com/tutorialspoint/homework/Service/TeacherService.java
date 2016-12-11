package com.tutorialspoint.homework.Service;

import com.tutorialspoint.homework.bean.Course;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/11.
 */
public interface TeacherService {
   public void add ( Course course );

   public List<Course> getList ();

   public void deleteCourse ( int id );
}
