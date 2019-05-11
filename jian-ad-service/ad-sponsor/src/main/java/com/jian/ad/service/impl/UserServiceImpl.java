package com.jian.ad.service.impl;

import com.jian.ad.constant.Constants;
import com.jian.ad.dao.AdUserRepository;
import com.jian.ad.entity.AdUser;
import com.jian.ad.exception.AdException;
import com.jian.ad.service.IUserService;
import com.jian.ad.utils.CommonUtils;
import com.jian.ad.vo.CreateUserRequest;
import com.jian.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j   //添加日志的属性
@Service
public class UserServiceImpl implements IUserService {


    private final  AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository adUserRepository){
        this.userRepository = adUserRepository;
    }
    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {

        //请求参数异常
        if (!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdUser oldUser = userRepository.findByUsername(request.getUsername());
        //判断当前系统中是否用同名的用户
        if(oldUser != null){
            throw  new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser newUser = userRepository.save(new AdUser(request.getUsername(), CommonUtils.md5(request.getUsername())));

        return new CreateUserResponse(newUser.getId(),newUser.getUsername() , newUser.getToken(),newUser.getCreateTime(), newUser.getUpdateTime());
    }
}
