package com.rw.ssd.monitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import oshi.software.os.NetworkParams;
import oshi.software.os.OperatingSystem;

/**
 * 网络基本信息
 * 
 * @author Simon
 * @create 2018-11-01 15:19
 * @desc
 **/
public class NetworkParametersInfo {
    private NetworkParametersInfo() {
    }

    public static Map<String, Object> info() {
        Map<String, Object> info = new HashMap<>();

        oshi.SystemInfo si = new oshi.SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        NetworkParams networkParams = os.getNetworkParams();

        info.put("hostname", networkParams.getHostName());
        info.put("domain name", networkParams.getDomainName());
        info.put("DNS servers", Arrays.toString(networkParams.getDnsServers()));
        info.put("IPv4 Gateway", networkParams.getIpv4DefaultGateway());
        info.put("IPv6 Gateway", networkParams.getIpv6DefaultGateway());

        return info;
    }
}
