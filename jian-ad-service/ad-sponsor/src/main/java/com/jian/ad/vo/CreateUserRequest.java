package com.jian.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 *  创建User的请求对象类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;

    //判断用户名是否为空，为空返回false，不为空返回true
    public boolean validate(){
        return !StringUtils.isEmpty(username);
    }
}
