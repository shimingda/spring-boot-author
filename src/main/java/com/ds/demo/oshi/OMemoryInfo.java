package com.ds.demo.oshi;

import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

/**
 * @author Simon
 * @create 2018-11-01 15:13
 * @desc
 **/
public class OMemoryInfo {
    public static void printMemory(GlobalMemory memory) {
        //内存，总内存
        System.out.println("Memory: " + FormatUtil.formatBytes(memory.getAvailable()) + "/"
                + FormatUtil.formatBytes(memory.getTotal()));

        //交换区内存
        System.out.println("Swap used: " + FormatUtil.formatBytes(memory.getSwapUsed()) + "/"
                + FormatUtil.formatBytes(memory.getSwapTotal()));
    }
}
