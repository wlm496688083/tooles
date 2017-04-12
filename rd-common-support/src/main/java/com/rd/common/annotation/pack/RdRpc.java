package com.rd.common.annotation.pack;

import com.rd.common.annotation.ConvertException;
import com.rd.common.annotation.Loggable;

import java.lang.annotation.*;

/**
 * Created by wanglimin1 on 2016/11/7.
 * SERVICE层
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Loggable
@ConvertException
public @interface RdRpc {
   /* @AliasFor(annotation = Loggable.class, attribute = "value")
    String logName() default "";*/
}
