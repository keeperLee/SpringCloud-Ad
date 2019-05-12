package com.jian.ad.controller;

import com.alibaba.fastjson.JSON;
import com.jian.ad.exception.AdException;
import com.jian.ad.service.IUserService;
import com.jian.ad.vo.CreateUserRequest;
import com.jian.ad.vo.CreateUserResponse;
import com.jian.ad.vo.CreativeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j   //lombok的日志注解
@RestController
public class UserOPController {

    private final IUserService userService;

    @Autowired
    public UserOPController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")     //使用RequestBody进行反序列化
    public CreateUserResponse createUser(
            @RequestBody CreateUserRequest request) throws AdException{
        log.info("ad-sponsor: createUser - > {}", JSON.toJSONString(request));
        return userService.createUser(request);

    }
}
