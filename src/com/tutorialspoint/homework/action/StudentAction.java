package com.tutorialspoint.homework.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.homework.Service.StudentService;
import com.tutorialspoint.homework.bean.Student;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class StudentAction extends ActionSupport {
    private StudentService service;

    public StudentService getService () {
        return service;
    }

    public void setService ( StudentService service ) {
        this.service = service;
    }

    public Student getStudent () {
        return student;
    }

    public void setStudent ( Student student ) {
        this.student = student;
    }

    private Student student=new Student();
    public String regist(){
        service.regist(student);
        return "StudentLogin";
    }
    public String login(){
if(service.login(student)) {
    return "loginSuccess";
}else{
    return "loginError";
}
    }


}
