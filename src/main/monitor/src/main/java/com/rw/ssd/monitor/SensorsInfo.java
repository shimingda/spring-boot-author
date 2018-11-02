package com.rw.ssd.monitor;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Simon
 * @create 2018-11-01 15:16
 * @desc
 **/
public class SensorsInfo {
//    @Autowired
//    Sensors sensor;

    public static String getCpuTemp(){
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        Sensors sensor=hal.getSensors();
        Double cupTemp=sensor.getCpuTemperature();

        DecimalFormat format = new DecimalFormat(" #.00°C");
        String finalCpuTemp = format.format(cupTemp);
        System.out.println(finalCpuTemp);
        return finalCpuTemp;
    }
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
