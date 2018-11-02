package com.rw.ssd.monitor.test;

import java.util.Map;

import org.junit.Test;

import com.rw.ssd.monitor.MemoryInfo;
import com.rw.ssd.monitor.NetworkParametersInfo;
import com.rw.ssd.monitor.UsbDevicesInfo;

public class TestMonitorInfo {
    @Test
    public void testUsbDevicesInfo() {
        Map<String, Object> info = UsbDevicesInfo.info();
        info.forEach((k, v) -> {
            System.out.println("k:" + k + "--v:" + v);
        });
    }

    public void testNetworkParameters() {
        Map<String, Object> info = NetworkParametersInfo.info();
        info.forEach((k, v) -> {
            System.out.println("k:" + k + "--v:" + v);
        });
    }

    public void testMemoryInfo() {
        Map<String, Object> info = MemoryInfo.info();
        info.forEach((k, v) -> {
            System.out.println("k:" + k + "--v:" + v);
        });
    }
}
