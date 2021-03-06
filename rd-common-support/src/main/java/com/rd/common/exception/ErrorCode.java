package com.rd.common.exception;


public interface ErrorCode {

    /**
     * 异常的状态码
     * @return
     */
    String getCode();

    /**
     * 异常的文字提示信息,尽量是人类能够看懂的通俗描述,使得发生了该错误的时候大部分都可以根据此提示自行解决问题,而不是选择咨询服务的提供方的开发人员.
     * @return
     */
    String getMsg();
}
