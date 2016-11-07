package com.rd.common.util;

import java.io.Serializable;

/**
 * Created by wanglimin1 on 2016/11/6.
 */
public class BaseResult<T> implements Serializable {

    private boolean isSuccess;
    private String code;
    private String msg;
    private T data;

    public static <T> BaseResult<T> newResult(boolean isSuccess, String code, String msg) {
        return new BaseResult<T>(isSuccess, code, msg, null);
    }

    public static <T> BaseResult<T> newResult(boolean isSuccess, String code, String msg, T t) {
        return new BaseResult<T>(isSuccess, code, msg, t);
    }

    public BaseResult(boolean isSuccess, String code, String msg, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
