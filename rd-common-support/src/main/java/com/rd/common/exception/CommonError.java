package com.rd.common.exception;


public enum CommonError implements ErrorCode {
    PARAMETER_EMPTY("%s不能为空"),
    BUSINESS_LIMIT("%s"),
    SYSTEM_ERROR("系统内部错误"),
    UNKNOWN_ERROR("不识别的错误"),
    JMQ_SEND_EXCEPTION("发送JMQ消息异常,topicId:%s ,businessId:%s"),
    CALL_JSF_EXCEPTION("调用JSF接口异常,接口名:%s ,别名:%s");

    private String msg;

    CommonError(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.name();
    }

    public String getMsg() {
        return msg;
    }
}
