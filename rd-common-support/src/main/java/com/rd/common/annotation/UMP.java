package com.rd.common.annotation;

import com.rd.common.rdenum.Key;

import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UMP {

    Key value();

}

