package com.fulinhua.action;


import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by fulinhua on 2017/3/8.
 */
public class test {

    public static void main(String[] args){
        JSONObject jsonObject=new JSONObject();
        ArrayList<String> name=new ArrayList<String>();
        name.add("绿地紫峰");
        name.add("厦门喜来登");
        ArrayList<Double> value=new ArrayList<Double>();
        value.add(100.9);
        value.add(32.0);
        jsonObject.put("name",name);
        jsonObject.put("value",value);
        System.out.println(jsonObject.toString());
    }
}
