package com.rw.ssd.monitor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.rw.ssd.monitor.factory.SingletonHardwareAbstractionLayer;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * 磁盘信息详情
 * 
 * @author Simon
 * @create 2018-11-01 15:18
 * @desc
 **/
public class DiskInfo {
    private DiskInfo() {
    }

    public static Map<String, Object> info() {
        Map<String, Object> info = new HashMap<>();
        info.put("write-rate", writeRate());
        info.put("read-rate", readRate());
        info.put("disks", printDisks());
        return info;
    }

    public static String writeRate() {

        long startWrite = writeSpeed();
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endWrite = writeSpeed();
        long endTime = System.currentTimeMillis();

        double resultTime = new BigDecimal((endTime - startTime) / 1000).setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        System.out.println("resultTime---" + resultTime);
        double resultWrite = new BigDecimal((endWrite - startWrite) / 1024).setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        System.out.println("resultWrite---" + resultWrite);
        double result = new BigDecimal(resultWrite / resultTime).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("result---" + result);
        DecimalFormat format = new DecimalFormat(" #KB/s");
        String finalWriteRate = format.format(result);
        System.out.println("finalWriteRate---" + finalWriteRate);
        return finalWriteRate;
    }

    public static long writeSpeed() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        HWDiskStore[] diskStores = hal.getDiskStores();
        System.out.println("Disks:");
        long writeByte = 0;
        long writeByteSum = 0;

        for (HWDiskStore disk : diskStores) {
            boolean readwrite = disk.getWrites() > 0;
            if (!readwrite) {
                continue;
            }
            writeByte = disk.getWriteBytes();
            writeByteSum += writeByte;

        }
        return writeByteSum;
    }

    public static String readRate() {

        long startRead = readSpeed();
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endRead = readSpeed();
        long endTime = System.currentTimeMillis();

        double resultTime = new BigDecimal((endTime - startTime) / 1000).setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        System.out.println("resultTime---" + resultTime);
        double resultRead = new BigDecimal((endRead - startRead) / 1024).setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        System.out.println("resultRead---" + resultRead);
        double result = new BigDecimal(resultRead / resultTime).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("result---" + result);
        DecimalFormat format = new DecimalFormat(" #KB/s");
        String finalReadRate = format.format(result);
        System.out.println("finalWriteRate---" + finalReadRate);
        return finalReadRate;
    }

    public static long readSpeed() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        HWDiskStore[] diskStores = hal.getDiskStores();
        System.out.println("Disks:");
        long readByte = 0;
        long readByteSum = 0;

        for (HWDiskStore disk : diskStores) {
            boolean readwrite = disk.getReads() > 0;
            if (!readwrite) {
                continue;
            }
            readByte = disk.getReadBytes();
            readByteSum += readByte;

        }
        return readByteSum;
    }

    public static Map<String, Object> printDisks() {
        HWDiskStore[] diskStores = SingletonHardwareAbstractionLayer.getSingle().getDiskStores();
        Map<String, Object> disksMap = new HashMap<>();

        for (HWDiskStore disk : diskStores) {

            Map<String, Object> diskMap = new HashMap<>();

            diskMap.put("model", disk.getModel());
            diskMap.put("size", disk.getSize());
            diskMap.put("serial", disk.getSerial());
            diskMap.put("transfer-time", disk.getTransferTime());

            disksMap.put(disk.getName(), diskMap);
        }
        return disksMap;
    }

}
