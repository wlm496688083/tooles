package com.rd.common.annotation.aspect;

import com.rd.common.annotation.Loggable;
import com.rd.common.contains.RdAnnotationContains;
import com.rd.common.util.JacksonUtil;
import com.rd.common.util.MailUtil;
import com.rd.common.util.ThrowableUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by wanglimin1 on 2016/10/27.
 * <p>
 */
@Aspect
@Component
public class EbaoLoggableAspect {

    @Around(value = RdAnnotationContains.EBAO_LOGGABLE_AROUND)
    public Object doProcess(ProceedingJoinPoint pjp) throws Throwable {

        Logger proxyLogger;
        Class<?> aClass = pjp.getTarget().getClass();

        //适用于spring 4.2 之前
        Loggable loggable = AnnotationUtils.findAnnotation(aClass, Loggable.class);
        if (loggable == null) {
            return pjp.proceed();
        }

        String methodName = pjp.getSignature().getName();

        if (!StringUtils.isEmpty(loggable.logName())) {
            proxyLogger = LoggerFactory.getLogger(loggable.logName());
        } else {
            proxyLogger = LoggerFactory.getLogger(aClass);
        }

        String argsJson = null;
        try {
            Object[] args = pjp.getArgs();
            if (args.length > 0) {
                argsJson = JacksonUtil.writeValueAsString(args);
            }

            proxyLogger.info("before invoke, method:{}, args:{}", methodName, argsJson);

            Object result = pjp.proceed();

            String resultJson = JacksonUtil.writeValueAsString(result);
            if (loggable.printResult()) {
                proxyLogger.info("after invoke, method:{}, args:{}, result:{}", methodName, argsJson, resultJson);
            } else {
                proxyLogger.info("after invoke, method:{}, args:{}", methodName, argsJson);
            }

            return result;
        } catch (Throwable cause) {
            proxyLogger.error("invoke fail, method:{}, args:{}", methodName, argsJson, cause);
            MailUtil.sendMail(ThrowableUtil.getThrowableDetail(cause));
            throw cause;
        }
    }

}
