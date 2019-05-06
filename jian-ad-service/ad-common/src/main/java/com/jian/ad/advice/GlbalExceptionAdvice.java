package com.jian.ad.advice;

import com.jian.ad.exception.AdException;
import com.jian.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice相当于ControllerAdvice + ResponseBody。
@RestControllerAdvice
public class GlbalExceptionAdvice {

    //拦截spring的异常处理需要使用到ExceptionHandler注解。Spring3.0引入的这个注解可以让我们在一个handler方法或者类中统一处理Controller抛出的异常
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req, AdException ex){
        CommonResponse<String> response = new CommonResponse<>(-1,"business error");
        response.setData(ex.getMessage());
        return response;
    }
}
