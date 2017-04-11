package com.rd.common.annotation.pack;

import com.rd.common.annotation.ConvertException;
import com.rd.common.annotation.Loggable;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * Created by wanglimin1 on 2016/11/7.
 * SERVICE层
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Loggable
@ConvertException
public @interface RdService {
    @AliasFor(annotation = Loggable.class, attribute = "value")
    String logName() default "";
}
