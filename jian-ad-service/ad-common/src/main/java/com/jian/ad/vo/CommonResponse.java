package com.jian.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一响应
 */
@Data  //getter和setter
@NoArgsConstructor  //无参构造函数
@AllArgsConstructor //全参构造函数
public class CommonResponse<T> implements Serializable {
    private Integer code;
    private String  message;
    private T data;

    public CommonResponse(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
