package com.jian.ad.service;

import com.jian.ad.entity.AdPlan;
import com.jian.ad.exception.AdException;
import com.jian.ad.vo.AdPlanGetRequest;
import com.jian.ad.vo.AdPlanRequest;
import com.jian.ad.vo.AdPlanResponse;

import java.util.List;


public interface IAdPlanService {

    //创建推广计划
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    //获取推广计划
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    //更新推广计划
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    //删除推广计划
    void deleAdPlan(AdPlanRequest request) throws  AdException;
}
