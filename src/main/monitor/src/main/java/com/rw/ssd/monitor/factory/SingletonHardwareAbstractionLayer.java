package com.rw.ssd.monitor.factory;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * 获取硬件抽象层
 * 
 * @author Administrator
 *
 */
public class SingletonHardwareAbstractionLayer {

    private SingletonHardwareAbstractionLayer() {

    }

    private static final HardwareAbstractionLayer hardwareAbstractionLayer = null;

    public static HardwareAbstractionLayer getSingle() {
        SystemInfo si = new SystemInfo();
        return si.getHardware();

    }
}
