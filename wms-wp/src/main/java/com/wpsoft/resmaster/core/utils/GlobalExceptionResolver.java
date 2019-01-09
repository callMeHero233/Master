package com.wpsoft.resmaster.core.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WP
 * @Description:
 * @Date: 16:38 2019/1/3
 * @Modified By:
 */
//@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> resMsg = new HashMap<String, Object>();
        StringPrintWriter strintPrintWriter = new StringPrintWriter();
        ex.printStackTrace(strintPrintWriter);

        //异常信息返回
        resMsg.put("errMsg", strintPrintWriter.getString());
        //根据不同的错误跳转不同的页面
        if(ex instanceof NoHandlerFoundException){
            //404异常
            resMsg.put("errCode", HttpServletResponse.SC_NOT_FOUND);
        }else{
            //500异常
            resMsg.put("errCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return new ModelAndView("exceptionErr", resMsg);
    }
}