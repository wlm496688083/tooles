package com.rd.common.mvcadvice;

import com.rd.common.exception.AbstractException;
import com.rd.common.exception.SystemRpcUnavailableException;
import com.rd.common.exception.SystemUnavailableException;
import com.rd.common.exception.ValidateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanglimin1 on 2016/11/4.
 * controller 层 异常统一管理
 */
@ControllerAdvice
public class MvcAdviceCommon {

    @ExceptionHandler({ValidateException.class, SystemRpcUnavailableException.class, SystemUnavailableException.class})
    public ModelAndView insideProcess(AbstractException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("isError", true);
        modelAndView.addObject("errCode", e.getCode());
        modelAndView.addObject("errMsg", e.getMsg());
        return modelAndView;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView exceptionProcess(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("isError", true);
        modelAndView.addObject("errMsg", e);
        return modelAndView;
    }
}
