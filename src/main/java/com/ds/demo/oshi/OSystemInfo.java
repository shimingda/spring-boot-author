package com.ds.demo.oshi;


import oshi.hardware.Baseboard;
import oshi.hardware.ComputerSystem;
import oshi.hardware.Firmware;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 * @author Simon
 * @create 2018-11-01 14:51
 * @desc
 **/
public class OSystemInfo {


    public static void printComputerSystem(final ComputerSystem computerSystem) {


        oshi.SystemInfo si = new oshi.SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        System.out.println(os);

        System.out.println("manufacturer: " + computerSystem.getManufacturer());//厂商
        System.out.println("model: " + computerSystem.getModel());//样式
        System.out.println("serialnumber: " + computerSystem.getSerialNumber());//序列号
        final Firmware firmware = computerSystem.getFirmware();
        System.out.println("firmware:");//防火墙
        System.out.println("  manufacturer: " + firmware.getManufacturer());//防火墙厂商
        System.out.println("  name: " + firmware.getName());//名称
        System.out.println("  description: " + firmware.getDescription());//描述
        System.out.println("  version: " + firmware.getVersion());//版本
        //发布时间
        System.out.println("  release date: " + (firmware.getReleaseDate() == null ? "unknown"
                : firmware.getReleaseDate() == null ? "unknown" : FormatUtil.formatDate(firmware.getReleaseDate())));
        final Baseboard baseboard = computerSystem.getBaseboard();
        System.out.println("baseboard:");//主板
        System.out.println("  manufacturer: " + baseboard.getManufacturer());//厂商
        System.out.println("  model: " + baseboard.getModel());//样式
        System.out.println("  version: " + baseboard.getVersion());//版本
        System.out.println("  serialnumber: " + baseboard.getSerialNumber());//序列号
    }
}
