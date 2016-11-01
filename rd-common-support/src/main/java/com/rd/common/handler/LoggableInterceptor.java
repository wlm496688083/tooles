package com.rd.common.handler;

import com.rd.common.annotation.Loggable;
import com.rd.common.util.JacksonUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

/**
 * Created by wanglimin1 on 2016/10/27.
 * <p>
 * todo 1,后期日志名称要加入缓存中，创建时 有锁，会影响性能.(内部已有缓存)
 * todo 2,动态获取日志级别
 */
public class LoggableInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Logger proxyLogger;
        Class<?> aClass = methodInvocation.getThis().getClass();
        Loggable loggable = AnnotationUtils.getAnnotation(aClass, Loggable.class);

        if (loggable == null) {
            return methodInvocation.proceed();
        }

        String methodName = methodInvocation.getMethod().getName();
        if (!StringUtils.isEmpty(loggable.logName())) {
            proxyLogger = LoggerFactory.getLogger(loggable.logName());
        } else {
            proxyLogger = LoggerFactory.getLogger(aClass);
        }

        String argsJson = null;
        try {
            argsJson = JacksonUtil.writeValueAsString(methodInvocation.getArguments());
            proxyLogger.info("before invoke, method:{}, args:{}", methodName, argsJson);

            Object result = methodInvocation.proceed();

            String resultJson = JacksonUtil.writeValueAsString(result);
            if (loggable.printResult()) {
                proxyLogger.info("after invoke, method:{}, args:{}, result:{}", methodName, argsJson, resultJson);
            } else {
                proxyLogger.info("after invoke, method:{}, args:{}", methodName, argsJson);
            }

            return result;
        } catch (Throwable cause) {
            proxyLogger.error("invoke fail, method:{}, args:{}", methodName, argsJson, cause);
            throw cause;
        }
    }
}
