package com.rd.common.test.util;

/**
 * Created by wanglimin1 on 2016/11/1.
 */
public class StringUtil {
    public static void main(String[] args) {
        String str = "qwe";
        System.out.println(String.valueOf(str.charAt(0)).toUpperCase().concat(str.substring(1)));
    }
}
