package com.rd.common.annotation.pack;

import com.rd.common.annotation.Loggable;
import com.rd.common.annotation.UMP;
import com.rd.common.rdenum.Key;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * Created by wanglimin1 on 2016/11/7.
 * CONTROLLER层
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@Loggable
@UMP(Key.CONTROLLER)
public @interface RdRestController {
    @AliasFor(annotation = Loggable.class, attribute = "value")
    String logName() default "";
}
