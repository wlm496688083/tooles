package com.rd.common.annotation;

import com.rd.common.rdenum.Key;

import java.lang.annotation.*;


/**
 * User:  fuxueliang
 * Date:  16/3/19
 * Email: fuxueliang@jd.com
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UMP {

    Key value();

}

