package com.rd.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2017/4/11.
 */
public class DateUtil {

    public static String getCurrDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
