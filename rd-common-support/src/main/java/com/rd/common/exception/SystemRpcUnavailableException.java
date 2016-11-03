package com.rd.common.exception;

/**
 * 调用系统外部异常
 * User:  fuxueliang
 * Date:  16/3/19
 * Email: fuxueliang@jd.com
 */
public class SystemRpcUnavailableException extends AbstractException {
    public SystemRpcUnavailableException(ErrorCode errorCode, Object... objs) {
        super(errorCode, objs);
    }

    public SystemRpcUnavailableException(ErrorCode errorCode, Throwable throwable, Object... objs) {
        super(errorCode, throwable, objs);
    }
}
