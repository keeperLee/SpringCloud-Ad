package com.jian.ad.dao;

import com.jian.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *   继承JpaRepository ，可以用于实现里面的数据操作方法，JpaRepository<AdUser,Long>参数是实体类及主键类型
 *    用户数据操作接口
 */
public interface AdUserRepository extends JpaRepository<AdUser,Long> {

    //根据用户名查找用户记录
    AdUser findByUsername(String username);


}
