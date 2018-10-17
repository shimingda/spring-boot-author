package com.ds.demo.check;

import java.util.Map;

/**
 * @author Simon
 * @create 2018-10-16 18:16
 * @desc
 **/
public class TestCheck {
    public static void main(String[] args) throws Exception {

//        System.out.println(MemoryInfo.getUseageRate());
//        System.out.println("----------------------------------------------------------------------------------------------");
//        CPUInfo.cpu();
//        System.out.println("----------------------------------------------------------------------------------------------");
          DiskInfo.file();
          Map<Double,String> map=DiskInfo.getUseageRate();
            for (Map.Entry<Double,String> entry :map.entrySet()) {
                System.out.println(entry.getKey()+"----------------"+entry.getValue());
            }
//        System.out.println("----------------------------------------------------------------------------------------------");
//        MemoryInfo.memory();
//        System.out.println("----------------------------------------------------------------------------------------------");
//        NetInfo.ethernet();
//        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
