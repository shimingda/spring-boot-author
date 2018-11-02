package com.ds.demo.oshi;


/**
 * @author Simon
 * @create 2018-11-01 14:43
 * @desc
 **/
public class SystemInfoTest {

    public static void main(String[] args) {

//        LOG.info("Initializing System...");
//        SystemInfo si = new SystemInfo();
//        HardwareAbstractionLayer hal = si.getHardware();
//        OperatingSystem os = si.getOperatingSystem();


//        LOG.info("Checking computer system...");
//        OSystemInfo.printComputerSystem(hal.getComputerSystem());

//??????????????????
//        LOG.info("Checking Processor...");
//        OProcessorInfo.printProcessor(hal.getProcessor());


//        LOG.info("Checking Memory...");
//        OMemoryInfo.printMemory(hal.getMemory());


//        LOG.info("Checking CPU...");
//        OCPUInfo.printCpu(hal.getProcessor());
//
//        LOG.info("Checking Processes...");
//        OProcessorInfo.printProcesses(os, hal.getMemory());

//        LOG.info("Checking Sensors...");
//        OSensorsInfo.printSensors(hal.getSensors());

//        LOG.info("Checking Power sources...");
//        OPowerSources.printPowerSources(hal.getPowerSources());

//        LOG.info("Checking Disks...");
//        ODiskInfo.printDisks(hal.getDiskStores());

//        LOG.info("Checking File System...");
//        OFileSystemInfo.printFileSystem(os.getFileSystem());

//        LOG.info("Checking Network interfaces...");
//        ONetworkInterfaces.printNetworkInterfaces(hal.getNetworkIFs());

//        LOG.info("Checking Network parameterss...");
//        ONetworkParameters.printNetworkParameters(os.getNetworkParams());

        // hardware: displays
//        LOG.info("Checking Displays...");
//        ODisplaysInfo.printDisplays(hal.getDisplays());

        // hardware: USB devices
//        LOG.info("Checking USB Devices...");
//        OUsbDevicesInfo.printUsbDevices(hal.getUsbDevices(true));
        ODiskInfo.writeRate();
//        OSensorsInfo.getCpuTemp();
    }
}