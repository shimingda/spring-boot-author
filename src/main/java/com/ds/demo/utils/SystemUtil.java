package com.ds.demo.utils;

import sun.security.x509.IPAddressName;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Simon
 * @create 2018-10-16 14:31
 * @desc
 **/
public class SystemUtil {
    private SystemUtil(){

    }

    /**
     * 获得ip地址
     * @return
     */
    public static String getIpAddress(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return  address.getHostAddress();
    }
}
