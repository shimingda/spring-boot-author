package com.ds.demo.utils;

/**
 * @author Simon
 * @create 2018-10-16 11:36
 * @desc
 **/
public class CPU {
    /**
     * 获取cpu温度
     *
     * @return
     */
    public String temp() {
        double temp = 0;
        String result = ExecUtil.execUtil("cat /sys/class/thermal/thermal_zone0/temp");
        temp = Double.parseDouble(result);
        temp = temp / 1000;
        return String.format("%.1f", temp);
    }
}
