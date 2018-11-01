package com.ds.demo.oshi;

import oshi.hardware.Display;

/**
 *  显示器信息
 * @author Simon
 * @create 2018-11-01 15:20
 * @desc
 **/
public class ODisplaysInfo {
    public static void printDisplays(Display[] displays) {
        System.out.println("Displays:");
        int i = 0;
        for (Display display : displays) {
            System.out.println(" Display " + i + ":");
            System.out.println(display.toString());
            i++;
        }
    }
}
