package com.tutorialspoint.homework.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.homework.Service.StudentService;
import com.tutorialspoint.homework.bean.Course;
import com.tutorialspoint.homework.bean.Student;
import com.tutorialspoint.homework.bean.StudentCourse;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * Created by fulinhua on 2016/12/11.
 */
public class StudentAction extends ActionSupport {
    private StudentService service;
    private List<Course> courselist;

    public List<StudentCourse> getMyCourses () {
        return myCourses;
    }

    public void setMyCourses ( List<StudentCourse> myCourses ) {
        this.myCourses = myCourses;
    }

    private List<StudentCourse> myCourses;
    private Course course=new Course();

    public Course getCourse () {
        return course;
    }

    public void setCourse ( Course course ) {
        this.course = course;
    }

    public List<Course> getCourselist () {
        return courselist;
    }

    public void setCourselist ( List<Course> courselist ) {
        this.courselist = courselist;
    }

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
        String result=service.login(student);
if(result!=null) {
    courselist=service.getCourseList();
    myCourses=(List<StudentCourse>)ServletActionContext.getRequest().getSession().getAttribute("MyCourses");
    return result;
}else{
    return "loginError";
}
    }
    public String select(){
        Student temp= (Student)ServletActionContext.getRequest().getSession().getAttribute("student");
        service.addCourse(temp,course);
        return "SelectCourse";
    }


}
