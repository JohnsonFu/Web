package com.fulinhua.action;

/**
 * Created by fulinhua on 2016/12/8.
 */
public class SimpleAction {
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    public String go(){
        return "index";
    }

    private String test="testtest";
}
