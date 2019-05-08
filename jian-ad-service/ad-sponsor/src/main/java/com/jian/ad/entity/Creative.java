package com.jian.ad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


//创意类
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_creative")
public class Creative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "name" , nullable = false)
    private String name;

    //图片，视频，或者是文本
    @Basic
    @Column(name = "type" , nullable = false)
    private Integer type;

    //物料类型,比如图片可以实bmp,jpg等等
    @Basic
    @Column(name = "material_type" , nullable = false)
    private Integer materialType;

    @Basic
    @Column(name = "height" , nullable = false)
    private Integer height;

    @Basic
    @Column(name = "width" , nullable = false)
    private Integer width;

    //物料大小
    @Basic
    @Column(name = "size" , nullable = false)
    private Long size;

    //持续时长，只有视频不为0
    @Basic
    @Column(name = "duration" , nullable = false)
    private Integer duration;

    //审核状态
    @Basic
    @Column(name = "audit_status" , nullable = false)
    private Integer auditStatus;

    @Basic
    @Column(name = "user_id" , nullable = false)
    private Long userId;

    @Basic
    @Column(name = "url" , nullable = false)
    private String url;

    @Basic
    @Column(name = "create_time" , nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time" , nullable = false)
    private Date updateTime;

}

