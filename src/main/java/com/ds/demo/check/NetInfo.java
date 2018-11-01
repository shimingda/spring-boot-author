package com.ds.demo.check;

import org.hyperic.sigar.*;

/**
 * @author Simon
 * @create 2018-10-16 18:07
 * @desc
 **/
public class NetInfo {
    private NetInfo(){

    }
    public static void test() throws SigarException {
        Sigar sigar = new Sigar();

        // 当前机器的正式域名
        try {
            System.out.println(sigar.getFQDN());// 即Fully Qualified Domain Name，中文为：全称域名
        } catch (SigarException e) {
            e.printStackTrace();
        }

        String[] netInterfaceList = sigar.getNetInterfaceList();

        // 获取网络流量信息
        for (int i = 0; i < netInterfaceList.length; i++) {
            String netInterface = netInterfaceList[i];// 网络接口
//            System.out.println("netInterface：" + netInterface);
            NetInterfaceConfig netInterfaceConfig = sigar.getNetInterfaceConfig(netInterface);
//            System.out.println("Address = " + netInterfaceConfig.getAddress());// IP地址
//            System.out.println("Netmask = " + netInterfaceConfig.getNetmask());// 子网掩码
            if ((netInterfaceConfig.getFlags() & 1L) <= 0L) {// 网络装置是否正常启用
                System.out.println("!IFF_UP...skipping getNetInterfaceStat");
                continue;
            }
            NetInterfaceStat netInterfaceStat = sigar.getNetInterfaceStat(netInterface);
            System.out.println("netInterfaceStat rxPackets：" + netInterfaceStat.getRxPackets());// 接收的总包裹数
            System.out.println("netInterfaceStat txPackets：" + netInterfaceStat.getTxPackets());// 发送的总包裹数
            System.out.println("netInterfaceStat rxBytes：" + netInterfaceStat.getRxBytes());// 接收到的总字节数
            System.out.println("netInterfaceStat txBytes：" + netInterfaceStat.getTxBytes());// 发送的总字节数
            System.out.println("netInterfaceStat rxErrors：" + netInterfaceStat.getRxErrors());// 接收到的错误包数
            System.out.println("netInterfaceStat txErrors：" + netInterfaceStat.getTxErrors());// 发送数据包时的错误数
            System.out.println("netInterfaceStat rxDropped：" + netInterfaceStat.getRxDropped());// 接收时丢弃的包数
            System.out.println("netInterfaceStat txDropped：" + netInterfaceStat.getTxDropped());// 发送时丢弃的包数
            System.out.println("netInterfaceStat rxOverruns：" + netInterfaceStat.getRxOverruns());
            System.out.println("netInterfaceStat txOverruns：" + netInterfaceStat.getTxOverruns());
            System.out.println("netInterfaceStat rxFrame：" + netInterfaceStat.getRxFrame());
            System.out.println("netInterfaceStat txCollisions：" + netInterfaceStat.getTxCollisions());
            System.out.println("netInterfaceStat txCarrier：" + netInterfaceStat.getTxCarrier());
            System.out.println("netInterfaceStat speed：" + netInterfaceStat.getSpeed());
        }

        sigar.close();
    }




    /**
     * 网络详情
     * @throws SigarException
     */
    public static void ethernet() throws SigarException {
        Sigar sigar = null;
        sigar = new Sigar();
        String[] ifaces = sigar.getNetInterfaceList();
        for (int i = 0; i < ifaces.length; i++) {
            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                continue;
            }

            System.out.println(cfg.getName() + "IP地址:" + cfg.getAddress());// IP地址
            System.out.println(cfg.getName() + "网关广播地址:" + cfg.getBroadcast());// 网关广播地址
            System.out.println(cfg.getName() + "网卡MAC地址:" + cfg.getHwaddr());// 网卡MAC地址
            System.out.println(cfg.getName() + "子网掩码:" + cfg.getNetmask());// 子网掩码
            System.out.println(cfg.getName() + "网卡描述信息:" + cfg.getDescription());// 网卡描述信息
            System.out.println(cfg.getName() + "网卡类型" + cfg.getType());//
        }
    }
}
