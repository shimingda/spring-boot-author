package com.ds.demo.check;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

import java.math.BigDecimal;


/**
 * @author Simon
 * @create 2018-10-16 17:12
 * @desc
 **/
public class MemoryInfo {

    private MemoryInfo(){

    }

    /**
     *
     * @return
     */
    public static double getUseageRate(){
        Sigar sigar = new Sigar();
        Mem mem=null;
        try {
           mem= sigar.getMem();
        } catch (SigarException e) {
            e.printStackTrace();
        }

        double memoryUseageRate = new BigDecimal((float)mem.getUsed()/mem.getTotal()).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        return memoryUseageRate;
    }
    /**
     * 内存详情
     * @throws SigarException
     */
    public static void memory() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        // 内存总量
        System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
        // 当前内存使用量
        System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
        // 当前内存剩余量
        System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
        Swap swap = sigar.getSwap();
        // 交换区总量
        System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
        // 当前交换区使用量
        System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
        // 当前交换区剩余量
        System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
    }


}
