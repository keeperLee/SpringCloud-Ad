package com.jian.ad.entity;

import com.jian.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户表实体类定义
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_user")
public class AdUser {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略为自增
    @Column(name = "id" , nullable = false)    //nullable 表示不能为Null 也不能为" "
    private Long id;

    @Basic  //基本属性，如果不指定，默认是Basic
    @Column(name = "username" , nullable = false)
    private String username;


    //@Transient//表示不映射数据库表中的字段
    @Basic
    @Column(name = "token", nullable = false)
    private String token;


    @Basic
    @Column(name = "user_status", nullable = false)
    private Integer userStatus;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public AdUser(String username, String token){
        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.Valid.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }

}
