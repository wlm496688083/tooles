package com.rd.common.exception;


public class ValidateException extends AbstractException {

    public ValidateException(ErrorCode errorCode, Object... objs) {
        super(errorCode, objs);
    }

    public ValidateException(ErrorCode errorCode, Throwable throwable, Object... objs) {
        super(errorCode, throwable, objs);
    }
}
