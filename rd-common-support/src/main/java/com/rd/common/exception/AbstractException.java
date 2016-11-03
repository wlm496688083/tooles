package com.rd.common.exception;

/**
 * User:  fuxueliang
 * Date:  16/3/19
 * Email: fuxueliang@jd.com
 */
public abstract class AbstractException extends RuntimeException {
    private String code;
    private String msg;

    public AbstractException(ErrorCode errorCode, Object... objs) {
        this(errorCode, null, objs);
    }

    public AbstractException(ErrorCode errorCode, Throwable throwable, Object... objs) {
        super(String.format(errorCode.getMsg(), objs), throwable);

        this.code = errorCode.getCode();

        if (objs == null || objs.length == 0) {
            this.msg = errorCode.getMsg().replace("%s", "");
            return;
        }
        this.msg = String.format(errorCode.getMsg(), objs);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
