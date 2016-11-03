package com.rd.common.exception;

/**
 * 校验参数异常 ,该类型异常也会计入 UMP 的 FunctionError
 * User:  fuxueliang
 * Date:  15/12/12
 * Email: fuxueliang@jd.com
 */
public class ValidateException extends AbstractException {

    public ValidateException(ErrorCode errorCode, Object... objs) {
        super(errorCode, objs);
    }

    public ValidateException(ErrorCode errorCode, Throwable throwable, Object... objs) {
        super(errorCode, throwable, objs);
    }
}
