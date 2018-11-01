package com.ds.demo.oshi;

import oshi.software.os.NetworkParams;

import java.util.Arrays;

/**
 *  网络基本信息
 * @author Simon
 * @create 2018-11-01 15:19
 * @desc
 **/
public class ONetworkParameters {
    public static void printNetworkParameters(NetworkParams networkParams) {
        System.out.println("Network parameters:");
        System.out.format(" Host name: %s%n", networkParams.getHostName());
        System.out.format(" Domain name: %s%n", networkParams.getDomainName());
        System.out.format(" DNS servers: %s%n", Arrays.toString(networkParams.getDnsServers()));
        System.out.format(" IPv4 Gateway: %s%n", networkParams.getIpv4DefaultGateway());
        System.out.format(" IPv6 Gateway: %s%n", networkParams.getIpv6DefaultGateway());
    }
}
