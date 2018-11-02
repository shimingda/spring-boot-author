package com.rw.ssd.monitor;

import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Simon
 * @create 2018-11-01 15:08
 * @desc
 **/
public class ProcessorInfo {
    public static void printProcessor(CentralProcessor processor) {
        System.out.println(processor);
        System.out.println(" " + processor.getPhysicalPackageCount() + " physical CPU package(s)");//物理cpu
        System.out.println(" " + processor.getPhysicalProcessorCount() + " physical CPU core(s)");//核
        System.out.println(" " + processor.getLogicalProcessorCount() + " logical CPU(s)");//逻辑cpu

        System.out.println("Identifier: " + processor.getIdentifier());//标识符
        System.out.println("ProcessorID: " + processor.getProcessorID());//id
    }

    public static void printProcesses(OperatingSystem os, GlobalMemory memory) {
        System.out.println("Processes: " + os.getProcessCount() + ", Threads: " + os.getThreadCount());
        // Sort by highest CPU
        List<OSProcess> procs = Arrays.asList(os.getProcesses(5, OperatingSystem.ProcessSort.CPU));

        System.out.println("   PID  %CPU %MEM       VSZ       RSS Name");
        for (int i = 0; i < procs.size() && i < 5; i++) {
            OSProcess p = procs.get(i);
            System.out.format(" %5d %5.1f %4.1f %9s %9s %s%n", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName());
        }
    }

}
