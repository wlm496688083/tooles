package com.rd.common.annotation.pack;

import com.rd.common.annotation.ConvertException;
import com.rd.common.annotation.Loggable;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * Created by wanglimin1 on 2016/11/7.
 * 对DB请求
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
@Loggable
@ConvertException
public @interface RdRepository {
    @AliasFor(annotation = Loggable.class, attribute = "value")
    String logName() default "";
}
