package com.ds.demo.oshi;

import oshi.hardware.Sensors;

import java.util.Arrays;

/**
 * @author Simon
 * @create 2018-11-01 15:16
 * @desc
 **/
public class OSensorsInfo {
    public static void printSensors(Sensors sensors) {
        System.out.println("Sensors:");
        //cup温度
        System.out.format(" CPU Temperature: %.1f°C%n", sensors.getCpuTemperature());
        //风扇转速
        System.out.println(" Fan Speeds: " + Arrays.toString(sensors.getFanSpeeds()));
        //cpu电压
        System.out.format(" CPU Voltage: %.1fV%n", sensors.getCpuVoltage());
    }
}
