package com.ds.demo.utils;

/**
 * @author Simon
 * @create 2018-10-16 12:35
 * @desc
 **/
public class StringUtil {

    private StringUtil(){

    }

    public static String getTempUnit(Object value){

        StringBuilder builder=new StringBuilder(String.valueOf( value));
        builder.append("℃");
        return String.valueOf(builder);
    }
}
