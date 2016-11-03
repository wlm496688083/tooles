package com.rd.common.aspect;

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

    @Around(value = "(execution(public * ((@com.rd.common.annotation.ConvertException *)+).*(..)) && within(@com.rd.common.annotation.ConvertException *)) || @annotation(com.rd.common.annotation.ConvertException)")
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
