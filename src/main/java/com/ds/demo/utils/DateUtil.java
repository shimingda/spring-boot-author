package com.ds.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转化
 */
public class DateUtil {
/*
    yyyy：年
    MM：月
    dd：日
    hh：1~12小时制(1-12)
    HH：24小时制(0-23)
    mm：分
    ss：秒
    S：毫秒
    E：星期几
    D：一年中的第几天
    F：一月中的第几个星期(会把这个月总共过的天数除以7)
    w：一年中的第几个星期
    W：一月中的第几星期(会根据实际情况来算)
    a：上下午标识
    k：和HH差不多，表示一天24小时制(1-24)
    K：和hh差不多，表示一天12小时制(0-11)
    z：表示时区
 */
    public static String transform(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());      // 时间戳转换成时间
        return date;
    }
    public String transform2(){
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String date = sdf2.format(new Date());
        return date;
    }
}
