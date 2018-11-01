package com.ds.demo.check;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @create 2018-10-16 17:16
 * @desc
 **/
public class DiskInfo {
    private DiskInfo(){

    }
    public static String writeRate(){
        long startWrite=writeSpeed();
        System.out.println("startWrite---"+startWrite);
        long startTime=System.currentTimeMillis();
        System.out.println("startTime---"+startTime);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endWrite=writeSpeed();
        System.out.println("endWrite---"+endWrite);
        long endTime=System.currentTimeMillis();
        System.out.println("endTime---"+endTime);
        System.out.println("resultTime---"+(endTime-startTime));
        System.out.println("resultWrite---"+(endWrite-startWrite));

        double resultTime=  new BigDecimal((endTime-startTime)/1000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double resultWrite=  new BigDecimal((endWrite-startWrite)/1024/1024).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double result=  new BigDecimal(resultWrite/resultTime).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("result---"+result);
        return null;
    }

    public  static long writeSpeed(){
        Sigar sigar=new Sigar();
        FileSystem fslist[]=null;
        try {
             fslist= sigar.getFileSystemList();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        long sum=0;
        long diskWrites;
        for (int i = 0; i < fslist.length; i++) {
            FileSystem fs = fslist[i];
            FileSystemUsage usage = null;
            try {
            usage = sigar.getFileSystemUsage(fs.getDirName());
            } catch (SigarException e) {
                continue;
            }
             diskWrites= usage.getDiskWriteBytes();
            System.out.println(diskWrites);
            sum+=diskWrites;
        }
        return sum;
    }
    public static Map<Double,String> getUseageRate(){
        Map<Double,String> map=new HashMap<>();
        Sigar sigar = new Sigar();
        FileSystem fslist[] = new FileSystem[0];

        try {
            fslist = sigar.getFileSystemList();
        } catch (SigarException e) {
            e.printStackTrace();
            return null;
        }

        for (int i = 0; i < fslist.length; i++) {
            FileSystem fs = fslist[i];
            // 分区的盘符名称
            String devName=fs.getDevName();
            FileSystemUsage usage = null;
            try {

                usage = sigar.getFileSystemUsage(fs.getDirName());
            }catch (Exception e){
                continue;
            }
            double usePercent = usage.getUsePercent();
            map.put(usePercent,devName);

        }
        return map;
    }
    /**
     * 磁盘详情
     * @throws Exception
     */
    public static void file() throws Exception {
        Sigar sigar = new Sigar();
        FileSystem fslist[] = sigar.getFileSystemList();
        for (int i = 0; i < fslist.length; i++) {
            System.out.println("分区的盘符名称" + i);
            FileSystem fs = fslist[i];
            // 分区的盘符名称
            System.out.println("盘符名称:    " + fs.getDevName());
            // 分区的盘符名称
            System.out.println("盘符路径:    " + fs.getDirName());
            System.out.println("盘符标志:    " + fs.getFlags());//
            // 文件系统类型，比如 FAT32、NTFS
            System.out.println("盘符类型:    " + fs.getSysTypeName());
            // 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
            System.out.println("盘符类型名:    " + fs.getTypeName());
            // 文件系统类型
            System.out.println("盘符文件系统类型:    " + fs.getType());
            FileSystemUsage usage = null;
            try {

                usage = sigar.getFileSystemUsage(fs.getDirName());
            }catch (Exception e){
            continue;
            }
            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    // 文件系统总大小
                    System.out.println(fs.getDevName() + "总大小:    " + usage.getTotal() + "KB");
                    // 文件系统剩余大小
                    System.out.println(fs.getDevName() + "剩余大小:    " + usage.getFree() + "KB");
                    // 文件系统可用大小
                    System.out.println(fs.getDevName() + "可用大小:    " + usage.getAvail() + "KB");
                    // 文件系统已经使用量
                    System.out.println(fs.getDevName() + "已经使用量:    " + usage.getUsed() + "KB");
                    double usePercent = usage.getUsePercent() * 100D;
                    // 文件系统资源的利用率
                    System.out.println(fs.getDevName() + "资源的利用率:    " + usePercent + "%");
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }
            System.out.println(fs.getDevName() + "读出：    " + usage.getDiskReads());
            System.out.println(fs.getDevName() + "写入：    " + usage.getDiskWrites());
        }
        return;
    }
}
