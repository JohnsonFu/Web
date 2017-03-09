package com.fulinhua.action;


import java.util.Date;

/**
 * Created by fulinhua on 2017/3/8.
 */
public class test {

    public static void main(String[] args){
        Date now=new Date();
        String[] date="2017-3-8".split("-");
        Date compare=new Date();
        compare.setYear(Integer.parseInt(date[0])-1900);
        compare.setMonth(Integer.parseInt(date[1])-1);
        compare.setDate(Integer.parseInt(date[2]));
        compare.setHours(1);
       System.out.println(compare);
        System.out.println(now);
        if(compare.after(now))
            System.out.println("big");
    }
}
