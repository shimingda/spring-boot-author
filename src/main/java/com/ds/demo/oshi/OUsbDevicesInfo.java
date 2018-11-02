package com.ds.demo.oshi;

import oshi.hardware.UsbDevice;

import java.util.HashMap;
import java.util.Map;

/**
 *  外接设备
 * @author Simon
 * @create 2018-11-01 15:20
 * @desc
 **/
public class OUsbDevicesInfo {

    private OUsbDevicesInfo(){}

    public static Map <String,Object> info(UsbDevice[] usbDevices) {
        Map <String,Object> info=new HashMap<>();
        for (UsbDevice usbDevice : usbDevices) {
            info.put(usbDevice.getName(),usbDevice.toString());
        }
    return info;
    }

}
