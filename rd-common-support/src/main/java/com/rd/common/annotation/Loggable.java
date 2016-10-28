package com.rd.common.annotation;

import java.lang.annotation.*;

/**
 * Created by wanglimin1 on 2016/10/27.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Loggable {

    String logName() default "";

}
