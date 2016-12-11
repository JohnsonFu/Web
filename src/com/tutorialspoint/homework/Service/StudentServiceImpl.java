package com.tutorialspoint.homework.Service;

import com.tutorialspoint.homework.bean.Course;
import com.tutorialspoint.homework.bean.Student;
import com.tutorialspoint.homework.bean.StudentCourse;
import com.tutorialspoint.struts2.dao.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class StudentServiceImpl implements StudentService {
    public BaseDao getDao () {
        return dao;
    }

    public void setDao ( BaseDao dao ) {
        this.dao = dao;
    }

    private BaseDao dao;
    @Override
    public void regist ( Student student ) {
        try {
            dao.add(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String login ( Student student ) {
         return dao.isExistStudent(student);
    }

    @Override
    public void addCourse ( Student student, Course course ) {
          dao.addCourse(student,course);
    }

    @Override
    public List<Course> getCourseList () {
        return (List<Course>) dao.getList("Course");
    }

    @Override
    public List<StudentCourse> getMyCourses ( Student student ) {

        return dao.getMyCourses(student);
    }
}
