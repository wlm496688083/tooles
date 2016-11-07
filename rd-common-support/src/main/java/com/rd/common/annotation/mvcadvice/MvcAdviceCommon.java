package com.rd.common.annotation.mvcadvice;

import com.rd.common.exception.AbstractException;
import com.rd.common.exception.CommonError;
import com.rd.common.util.BaseResult;
import com.rd.common.util.JacksonUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wanglimin1 on 2016/11/4.
 * controller 层 异常统一管理
 */
@ControllerAdvice
public class MvcAdviceCommon {

    /**
     * 适用于AJAX 和 跳转页面
     *
     * @param e 异常
     * @return 返回页面
     */
    @ExceptionHandler(Exception.class)
    public String insideProcess(HttpServletRequest request, HttpServletResponse response, Exception e) {
        String ajax = request.getHeader("X-Requested-With");
        if (StringUtils.isEmpty(ajax)) {
            return "error";
        }

        BaseResult baseResult;
        String json;
        if (e instanceof AbstractException) {
            AbstractException abstractException = (AbstractException) e;
            baseResult = BaseResult.newResult(false, abstractException.getCode(), abstractException.getMsg());
        } else {
            baseResult = BaseResult.newResult(false, CommonError.SYSTEM_ERROR.getCode(), CommonError.SYSTEM_ERROR.getMsg() + "," + e.getMessage());
        }
        json = JacksonUtil.writeValueAsString(baseResult);

        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/json");
            response.getWriter().write(json);
            response.getWriter().flush();
        } catch (IOException ignored) {
            ;
        }
        return null;
    }
}
