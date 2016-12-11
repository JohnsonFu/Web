package com.tutorialspoint.homework.Service;

import com.tutorialspoint.homework.bean.Course;
import com.tutorialspoint.struts2.dao.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class TeacherServiceImpl implements TeacherService {
    private BaseDao dao;

    public BaseDao getDao () {
        return dao;
    }

    public void setDao ( BaseDao dao ) {
        this.dao = dao;
    }

    @Override
    public void add ( Course course ) {
        try {
            dao.add(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getList () {
       return (List<Course>)dao.getList("Course");
    }

    @Override
    public void deleteCourse ( int id ) {
        dao.deleteCourse(id);
    }
}
