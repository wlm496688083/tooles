package com.rd.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by admin on 2017/4/11.
 */
public class IpUtil {

    public static String getLocalIp() {
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            return "local";
        }
    }
}
