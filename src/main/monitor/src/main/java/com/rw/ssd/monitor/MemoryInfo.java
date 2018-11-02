package com.rw.ssd.monitor;

import java.util.HashMap;
import java.util.Map;

import com.rw.ssd.monitor.factory.SingletonHardwareAbstractionLayer;

import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

/**
 * 获取内存状态
 * 
 * @author Simon
 * @create 2018-11-01 15:13
 * @desc
 **/
public class MemoryInfo {
    private MemoryInfo() {
    }

    public static Map<String, Object> info() {

        Map<String, Object> info = new HashMap();
        GlobalMemory memory = SingletonHardwareAbstractionLayer.getSingle().getMemory();

        // 可用内存
        info.put("available", FormatUtil.formatBytes(memory.getAvailable()));
        // 总内存
        info.put("total", FormatUtil.formatBytes(memory.getTotal()));

        // 交换区可用内存
        info.put("swap-used", FormatUtil.formatBytes(memory.getSwapUsed()));
        // 交换区总内存
        info.put("swap-used-total", FormatUtil.formatBytes(memory.getSwapTotal()));

        return info;
    }
}
