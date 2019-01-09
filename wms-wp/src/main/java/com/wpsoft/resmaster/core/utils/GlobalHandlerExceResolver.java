package com.wpsoft.resmaster.core.utils;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



/**
 * @Author: WP
 * @Description: 全局异常处理
 * @Date: 14:57 2019/1/3
 * @Modified By:
 */
@ControllerAdvice
public class GlobalHandlerExceResolver{
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //异常信息返回
        Map<String, Object> resMsg = new HashMap<String, Object>();
        StringPrintWriter strintPrintWriter = new StringPrintWriter();
        ex.printStackTrace(strintPrintWriter);
        resMsg.put("errMsg", strintPrintWriter.getString());

        if (ex instanceof HttpRequestMethodNotSupportedException) {
            //405
            resMsg.put("errCode", HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }else if (ex instanceof MissingServletRequestParameterException) {
            //400
            resMsg.put("errCode", HttpServletResponse.SC_BAD_REQUEST);
        }else if (ex instanceof NoHandlerFoundException) {
            //404
            //可以进行其他方法处理，LOG或者什么详细记录，我这里直接返回JSON
            resMsg.put("errCode", HttpServletResponse.SC_NOT_FOUND);
        }else{
            //500
            resMsg.put("errCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return new ModelAndView("common/exceptionErr", resMsg);
    }
}
