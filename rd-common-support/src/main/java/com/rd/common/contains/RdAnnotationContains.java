package com.rd.common.contains;

/**
 * Created by wanglimin1 on 2016/11/7.
 */
public class RdAnnotationContains {

    public static final String RD_LOGGABLE_AROUND = "(execution(public * *(..)) && (within(@com.rd.common.annotation.Loggable *) || " +
            "within(@com.rd.common.annotation.pack.RdController *) || within(@com.rd.common.annotation.pack.RdService *) || within(@com.rd.common.annotation.pack.RdRepository *) || within(@com.rd.common.annotation.pack.RdRpc *)) || " +
            "@annotation(com.rd.common.annotation.Loggable))";
    public static final String RD_CONVERTEXCEPTION_AROUND = "(execution(public * *(..)) && (within(@com.rd.common.annotation.ConvertException *) || " +
            "within(@com.rd.common.annotation.pack.RdController *) || within(@com.rd.common.annotation.pack.RdService *) || within(@com.rd.common.annotation.pack.RdRepository *) || within(@com.rd.common.annotation.pack.RdRpc *)) || " +
            "@annotation(com.rd.common.annotation.ConvertException))";

    //ebao
    public static final String EBAO_LOGGABLE_AROUND = "(execution(public * *(..)) && (within(@com.rd.common.annotation.Loggable *) || " +
            "@annotation(com.rd.common.annotation.Loggable)))";
}
