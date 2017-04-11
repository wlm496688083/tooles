package com.rd.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 获取异常栈信息
 * Created by admin on 2017/4/11.
 */
public class ThrowableUtil {

    public static String getThrowableDetail(Throwable cause) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        try {
            cause.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            try {
                stringWriter.close();
            } catch (IOException ignored) {

            }
            printWriter.close();
        }
    }
}
