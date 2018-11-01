package com.ds.demo.oshi;

import oshi.hardware.UsbDevice;

/**
 *  外接设备
 * @author Simon
 * @create 2018-11-01 15:20
 * @desc
 **/
public class OUsbDevicesInfo {

    public static void printUsbDevices(UsbDevice[] usbDevices) {
        System.out.println("USB Devices:");
        for (UsbDevice usbDevice : usbDevices) {
            System.out.println(usbDevice.toString());
        }
    }

}
