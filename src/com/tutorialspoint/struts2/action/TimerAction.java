package com.tutorialspoint.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by fulinhua on 2016/12/10.
 */
public class TimerAction extends ActionSupport {

    public String execute() throws InterruptedException {
        Thread.sleep(1000);
        return "success";
    }
}
