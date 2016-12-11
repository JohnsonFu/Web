package com.tutorialspoint.homework.Service;

import com.tutorialspoint.homework.bean.Student;
import com.tutorialspoint.struts2.dao.BaseDao;

import java.sql.SQLException;

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
    public boolean login ( Student student ) {
        return dao.isExistStudent(student);
    }
}
