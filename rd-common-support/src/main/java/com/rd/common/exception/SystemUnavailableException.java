package com.rd.common.exception;

/**
 * 系统内部异常
 * User:  fuxueliang
 * Date:  15/12/17
 * Email: fuxueliang@jd.com
 */
public class SystemUnavailableException extends AbstractException {
    public SystemUnavailableException(ErrorCode errorCode, Object... objs) {
        super(errorCode, objs);
    }

    public SystemUnavailableException(ErrorCode errorCode, Throwable throwable, Object... objs) {
        super(errorCode, throwable, objs);
    }
}
