package com.rd.common.annotation.aspect;

import com.rd.common.contains.RdAnnotationContains;
import com.rd.common.exception.CommonError;
import com.rd.common.exception.SystemRpcUnavailableException;
import com.rd.common.exception.SystemUnavailableException;
import com.rd.common.exception.ValidateException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RdConvertExceptionAspect {

    @Around(value = RdAnnotationContains.RD_CONVERTEXCEPTION_AROUND)
    public Object around(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (ValidateException e) {
            throw e;
        } catch (SystemRpcUnavailableException e) {
            throw e;
        } catch (SystemUnavailableException e) {
            throw e;
        } catch (Throwable e) {
            throw new SystemUnavailableException(CommonError.SYSTEM_ERROR, e);
        }
    }
}
