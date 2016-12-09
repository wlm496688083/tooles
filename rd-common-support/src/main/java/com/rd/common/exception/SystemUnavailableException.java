package com.rd.common.exception;


public class SystemUnavailableException extends AbstractException {
    public SystemUnavailableException(ErrorCode errorCode, Object... objs) {
        super(errorCode, objs);
    }

    public SystemUnavailableException(ErrorCode errorCode, Throwable throwable, Object... objs) {
        super(errorCode, throwable, objs);
    }
}
