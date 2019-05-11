package com.jian.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *  创建用户后返回给广告主的响应对象类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {

    //创建后的id
    private Long userId;

    //创建后的用户名
    private String username;

    //创建后的token
    private String token;

    //创建的时间
    private Date createTime;

    //更新时间
    private Date updateTime;
}
