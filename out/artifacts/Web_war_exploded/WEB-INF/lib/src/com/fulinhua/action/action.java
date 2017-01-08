package com.fulinhua.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by fulinhua on 2017/1/8.
 */
public class action extends ActionSupport{
    public String getAjaxField() {
        return ajaxField;
    }

    public void setAjaxField(String ajaxField) {
        this.ajaxField = ajaxField;
    }

    private String ajaxField;
    public String execute() {
        ajaxField = "hello " + ajaxField;
        return SUCCESS;
    }
}
