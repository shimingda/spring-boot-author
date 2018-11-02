package com.ds.demo.oshi;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *  磁盘信息详情
 * @author Simon
 * @create 2018-11-01 15:18
 * @desc
 **/
public class ODiskInfo {
    private ODiskInfo(){}

    public static String writeRate(){

        long startWrite=writeSpeed();
        long startTime=System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endWrite=writeSpeed();
        long endTime=System.currentTimeMillis();

        double resultTime=  new BigDecimal((endTime-startTime)/1000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("resultTime---"+resultTime);
        double resultWrite=  new BigDecimal((endWrite-startWrite)/1024).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("resultWrite---"+resultWrite);
        double result=  new BigDecimal(resultWrite/resultTime).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("result---"+result);
        DecimalFormat format = new DecimalFormat(" #KB/s");
        String finalWriteRate=format.format(result);
        System.out.println("finalWriteRate---"+finalWriteRate);
        return finalWriteRate;
    }

    public  static long writeSpeed(){
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        HWDiskStore[] diskStores=hal.getDiskStores();
        System.out.println("Disks:");
        long writeByte=0;
        long writeByteSum=0;

        for (HWDiskStore disk : diskStores) {
            boolean readwrite = disk.getWrites() > 0;
            if (!readwrite){
                continue;
            }
            writeByte= disk.getWriteBytes();
            writeByteSum+=writeByte;

        }
        return writeByteSum ;
    }
    public static String readRate(){

        long startRead=readSpeed();
        long startTime=System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endRead=readSpeed();
        long endTime=System.currentTimeMillis();

        double resultTime=  new BigDecimal((endTime-startTime)/1000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("resultTime---"+resultTime);
        double resultRead=  new BigDecimal((endRead-startRead)/1024).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("resultRead---"+resultRead);
        double result=  new BigDecimal(resultRead/resultTime).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("result---"+result);
        DecimalFormat format = new DecimalFormat(" #KB/s");
        String finalReadRate=format.format(result);
        System.out.println("finalWriteRate---"+finalReadRate);
        return finalReadRate;
    }
    public  static long readSpeed(){
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        HWDiskStore[] diskStores=hal.getDiskStores();
        System.out.println("Disks:");
        long readByte=0;
        long readByteSum=0;

        for (HWDiskStore disk : diskStores) {
            boolean readwrite = disk.getReads() > 0 ;
            if (!readwrite){
                continue;
            }
            readByte= disk.getReadBytes();
            readByteSum+=readByte;

        }
        return readByteSum ;
    }
    public static void printDisks(HWDiskStore[] diskStores) {
        System.out.println("Disks:");
        for (HWDiskStore disk : diskStores) {
            boolean readwrite = disk.getReads() > 0 || disk.getWrites() > 0;
            System.out.format(" %s: (model: %s - S/N: %s) size: %s, reads: %s (%s), writes: %s (%s), xfer: %s ms%n",
                    disk.getName(), disk.getModel(), disk.getSerial(),
                    disk.getSize() > 0 ? FormatUtil.formatBytesDecimal(disk.getSize()) : "?",
                    readwrite ? disk.getReads() : "?",
                    readwrite ? FormatUtil.formatBytes(disk.getReadBytes()) : "?",
                    readwrite ? disk.getWrites() : "?",
                    readwrite ? FormatUtil.formatBytes(disk.getWriteBytes()) : "?",
                    readwrite ? disk.getTransferTime() : "?");
            HWPartition[] partitions = disk.getPartitions();
            if (partitions == null) {
                // TODO Remove when all OS's implemented
                continue;
            }
            for (HWPartition part : partitions) {
                System.out.format(" |-- %s: %s (%s) Maj:Min=%d:%d, size: %s%s%n", part.getIdentification(),
                        part.getName(), part.getType(), part.getMajor(), part.getMinor(),
                        FormatUtil.formatBytesDecimal(part.getSize()),
                        part.getMountPoint().isEmpty() ? "" : " @ " + part.getMountPoint());
            }
        }
    }

}
