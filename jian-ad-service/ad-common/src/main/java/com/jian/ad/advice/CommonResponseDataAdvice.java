package com.jian.ad.advice;

import com.jian.ad.annotation.IgnoreResponseAdvice;
import com.jian.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//ResponseBodyAdvice 的作用是在响应体返回之前做一些自定义的处理工作，通常，我们会实现ResponseBodyAdvice接口，并包装统一的响应返回。
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    //判断是否需要对响应进行处理
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        //如果当前方法所在的类标识了IgnoreResponseAdvice注解，则不需要处理
        if(methodParameter.getDeclaringClass().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }
        //如果当前方法标识了IgnoreResponseAdvice注解，则不需要处理
        if(methodParameter.getMethod().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }
        //对响应进行处理，执行beforeBodyWrite方法
        return true;
    }

    //这个方法实现了在结果输出前的操作，参数Object，就是原始的Controller的返回的内容。我们也是需要对它进行包装
    @Nullable
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        //定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0,"");
        //o代表返回对象，如果o为null,则response不需要设置data
        if(null == o){
            return response;
            //如果o已经是CommonResponse类型，强装即可
        }else if(o instanceof CommonResponse){
            response = (CommonResponse<Object>)o;
            //否则，把响应对象作为CommonResponse的data部分
        }else{
            response.setData(o);
        }
        return response;
    }
}
