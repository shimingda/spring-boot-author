package com.ds.demo.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;

/**
 * @author Simon
 * @create 2018-10-16 18:16
 * @desc
 **/

public class TestCheck {
    @Autowired
    MetricsEndpoint metricsEndpoint;

    public static void main(String[] args) throws Exception {
//        System.out.println(System.getProperty("java.library.path"));
//        String result = "27800";
//        System.out.println(result);
//        DecimalFormat df = new DecimalFormat("#.0");
//        df.format(result);
//         Double a=Double.parseDouble(result);
//        System.out.println(a.toString());
////        System.out.println(MemoryInfo.getUseageRate());
//        System.out.println("----------------------------------------------------------------------------------------------");
//        CPUInfo.cpu();
//        System.out.println("----------------------------------------------------------------------------------------------");
//          DiskInfo.file();
//          Map<Double,String> map=DiskInfo.getUseageRate();
//            for (Map.Entry<Double,String> entry :map.entrySet()) {
//                System.out.println(entry.getKey()+"----------------"+entry.getValue());
//            }
//        System.out.println("----------------------------------------------------------------------------------------------");
//        MemoryInfo.memory();
//        System.out.println("----------------------------------------------------------------------------------------------");
//        NetInfo.ethernet();
//        System.out.println("----------------------------------------------------------------------------------------------");

//        DiskInfo.writeRate();

//        TestCheck testCheck=new TestCheck();
//        testCheck.get();

            NetInfo.test();
    }
    public  void get(){
        System.out.println(        metricsEndpoint.listNames());

    }
}
