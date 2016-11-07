package com.rd.common.annotation.aspect;


import com.jd.ump.profiler.CallerInfo;
import com.jd.ump.profiler.proxy.Profiler;
import com.rd.common.annotation.UMP;
import com.rd.common.contains.RdAnnotationContains;
import com.rd.common.rdenum.Key;
import com.rd.common.util.PropertiesUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/**
 * User:  fuxueliang
 * Date:  2016/9/26
 * Email: fuxueliang@jd.com
 * <p>
 * edit by:wanglimin14
 * 支持低版本的spring
 */
@Aspect
@Component
public class RdUmpAspect {

    @Around(value = RdAnnotationContains.RD_UMP_AROUND)
    public Object doProcess(ProceedingJoinPoint pjp) throws Throwable {

        CallerInfo info = null;
        try {
            Class<?> aClass = pjp.getTarget().getClass();
            UMP ump = AnnotationUtils.findAnnotation(aClass, UMP.class);

            if (null != ump) {
                String appName = PropertiesUtil.getAppName();
                String umpKey = getUmpKey(appName, aClass.getSimpleName(), pjp.getSignature().getName(), ump);
                info = Profiler.registerInfo(umpKey, appName, false, true);
            }
            return pjp.proceed();
        } catch (Throwable cause) {
            Profiler.functionError(info);
            throw cause;
        } finally {
            Profiler.registerInfoEnd(info);
        }
    }

    private String getUmpKey(String appName, String className, String methodName, UMP ump) {
        String prefix = Key.getPrefix(ump.value());
        if (StringUtils.isEmpty(prefix)) {
            return MessageFormatter.arrayFormat("{}.{}.{}", new Object[]{
                    appName, className, methodName
            }).getMessage();
        } else {
            return MessageFormatter.arrayFormat("{}.{}.{}.{}", new Object[]{
                    appName, prefix, className, methodName
            }).getMessage();
        }
    }

}
