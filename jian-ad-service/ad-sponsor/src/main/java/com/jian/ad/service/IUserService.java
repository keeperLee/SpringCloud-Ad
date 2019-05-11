package com.jian.ad.service;

import com.jian.ad.exception.AdException;
import com.jian.ad.vo.CreateUserRequest;
import com.jian.ad.vo.CreateUserResponse;

/**
 *  用户相关服务接口
 */
public interface IUserService {

    //创建用户
    CreateUserResponse createUser(CreateUserRequest  request) throws AdException;
}
