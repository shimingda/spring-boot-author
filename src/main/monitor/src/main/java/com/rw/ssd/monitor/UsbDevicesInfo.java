package com.rw.ssd.monitor;

import java.util.HashMap;
import java.util.Map;

import com.rw.ssd.monitor.factory.SingletonHardwareAbstractionLayer;

import oshi.hardware.UsbDevice;

/**
 * 外接设备
 * 
 * @author Simon
 * @create 2018-11-01 15:20
 * @desc
 **/
public class UsbDevicesInfo {

    private UsbDevicesInfo() {
    }

    public static Map<String, Object> info() {
        UsbDevice[] usbDevices = SingletonHardwareAbstractionLayer.getSingle().getUsbDevices(true);
        Map<String, Object> info = new HashMap<>();
        for (UsbDevice usbDevice : usbDevices) {
            info.put(usbDevice.getName(), usbDevice.toString());
        }
        return info;
    }

}
