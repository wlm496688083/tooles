package com.rd.common.exception;


public class SystemRpcUnavailableException extends AbstractException {
    public SystemRpcUnavailableException(ErrorCode errorCode, Object... objs) {
        super(errorCode, objs);
    }

    public SystemRpcUnavailableException(ErrorCode errorCode, Throwable throwable, Object... objs) {
        super(errorCode, throwable, objs);
    }
}
