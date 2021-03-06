package com.rd.common.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by wanglimin1 on 2016/10/27.
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Loggable {

    /**
     * 日志名称，默认打到当前类
     */
    @AliasFor("value")
    String logName() default "";

    @AliasFor("logName")
    String value() default "";

    /**
     * 是否打印结果集，默认不打印，防止大量结果集时系统变慢
     * 如果结果集少量的话，建议开启
     */
    boolean printResult() default false;

}
