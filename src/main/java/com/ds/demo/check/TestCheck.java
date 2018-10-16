package com.ds.demo.check;

import org.hyperic.sigar.SigarException;

/**
 * @author Simon
 * @create 2018-10-16 18:16
 * @desc
 **/
public class TestCheck {
    public static void main(String[] args) throws Exception {

        System.out.println("----------------------------------------------------------------------------------------------");
        CPUInfo.cpu();
        System.out.println("----------------------------------------------------------------------------------------------");
        DiskInfo.file();
        System.out.println("----------------------------------------------------------------------------------------------");
        MemoryInfo.memory();
        System.out.println("----------------------------------------------------------------------------------------------");
        NetInfo.ethernet();
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
