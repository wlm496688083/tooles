package com.rd.common.annotation.pack;

import com.rd.common.annotation.ConvertException;
import com.rd.common.annotation.Loggable;
import com.rd.common.annotation.UMP;
import com.rd.common.rdenum.Key;

import java.lang.annotation.*;

/**
 * Created by wanglimin1 on 2016/11/7.
 * 对DB请求
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Loggable
@UMP(Key.REPOSITORY)
@ConvertException
public @interface RdRepository {
}
