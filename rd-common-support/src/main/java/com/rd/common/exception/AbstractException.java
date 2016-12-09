package com.rd.common.exception;

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
        } else {
            this.msg = String.format(errorCode.getMsg(), objs);
        }
        if (throwable != null) {
            this.msg += " , detail : " + throwable.getMessage();
        }

    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
