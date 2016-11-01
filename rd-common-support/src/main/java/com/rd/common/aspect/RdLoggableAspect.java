package com.rd.common.aspect;

import com.rd.common.annotation.Loggable;
import com.rd.common.util.JacksonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wanglimin1 on 2016/10/27.
 * <p>
 */
@Aspect
@Component
public class RdLoggableAspect {

    @Around(value = "(execution(public * ((@com.rd.common.annotation.Loggable *)+).*(..)) && within(@com.rd.common.annotation.Loggable *)) || @annotation(com.rd.common.annotation.Loggable)")
    public Object doProcess(ProceedingJoinPoint pjp) throws Throwable {

        Logger proxyLogger;
        Class<?> aClass = pjp.getTarget().getClass();
        Loggable loggable = AnnotationUtils.findAnnotation(aClass, Loggable.class);

        if (loggable == null) {
            return pjp.proceed();
        }

        initClassAndDeclaredFields(aClass);
        String methodName = pjp.getSignature().getName();
        if (doFilterLog(aClass, methodName)) {
            return pjp.proceed();
        }

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
            throw cause;
        }
    }

    private Map<String, Map<String, Boolean>> map = new ConcurrentHashMap<String, Map<String, Boolean>>(128);


    /**
     * 第一次获取时 先初始化 当前类和属性的关系
     *
     * @param aClass 当前实例
     */
    private void initClassAndDeclaredFields(Class<?> aClass) {
        String className = aClass.getName();
        Map<String, Boolean> declaredFieldMap = map.get(className);
        if (declaredFieldMap == null) {
            declaredFieldMap = new ConcurrentHashMap<String, Boolean>();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                declaredFieldMap.put("get" + toUpStr(field.getName()), true);
                declaredFieldMap.put("set" + toUpStr(field.getName()), true);
            }
            map.put(className, declaredFieldMap);
        }
    }

    /**
     * 过滤一些 已知的无用方法日志的打印
     * eg: get,set
     *
     * @param aClass     当前类
     * @param methodName 当前方法名
     */
    private boolean doFilterLog(Class<?> aClass, String methodName) {
        Map<String, Boolean> declaredFieldMap = map.get(aClass.getName());
        return declaredFieldMap.get(methodName) != null;
    }

    private String toUpStr(String str) {
        return String.valueOf(str.charAt(0)).toUpperCase().concat(str.substring(1));
    }

}
