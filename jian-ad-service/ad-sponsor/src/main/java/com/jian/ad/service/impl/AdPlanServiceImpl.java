package com.jian.ad.service.impl;

import com.jian.ad.constant.CommonStatus;
import com.jian.ad.constant.Constants;
import com.jian.ad.dao.AdPlanRepository;
import com.jian.ad.dao.AdUserRepository;
import com.jian.ad.entity.AdPlan;
import com.jian.ad.entity.AdUser;
import com.jian.ad.exception.AdException;
import com.jian.ad.service.IAdPlanService;
import com.jian.ad.utils.CommonUtils;
import com.jian.ad.vo.AdPlanGetRequest;
import com.jian.ad.vo.AdPlanRequest;
import com.jian.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdPlanServiceImpl  implements IAdPlanService {

    private final AdUserRepository adUserRepository;
    private final AdPlanRepository adPlanRepository;

    @Autowired
    public AdPlanServiceImpl(AdUserRepository adUserRepository, AdPlanRepository adPlanRepository) {
        this.adUserRepository = adUserRepository;
        this.adPlanRepository = adPlanRepository;
    }

    @Override
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {

        if(!request.createValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //确保关联的user对象是存在的
        Optional<AdUser> adUser = adUserRepository.findById(request.getUserId());

        //如果adUser不存在
        if(!adUser.isPresent()){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        //判断是否之前有同名的Adplan
        AdPlan oldPlan = adPlanRepository.findUserIdAndPlanName(request.getUserId(), request.getPlanName());
        if(oldPlan != null){
            throw  new AdException(Constants.ErrorMsg.SAME_NAME_PLAN_ERROR);
        }
        AdPlan newPlan = adPlanRepository.save(new AdPlan(request.getUserId(),request.getPlanName(),
                CommonUtils.parseStringDate(request.getStartDate()),CommonUtils.parseStringDate(request.getEndDate())));
        return new AdPlanResponse(newPlan.getId(),newPlan.getPlanName());
    }

    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        if (!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        return adPlanRepository.findAllByIdInAndUserId(request.getIds(),request.getUserId());
    }

    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {

        if(!request.updateValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdPlan plan = adPlanRepository.findByIdAndUserId(request.getId(),request.getUserId());
        if(plan == null){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        if (request.getPlanName() != null){
            plan.setPlanName(request.getPlanName());
        }
        if(request.getStartDate() != null){
            plan.setStartDate(CommonUtils.parseStringDate(request.getStartDate()));
        }
        if(request.getEndDate() != null){
            plan.setStartDate(CommonUtils.parseStringDate(request.getEndDate()));
        }
        plan.setUpdateTime(new Date());
        plan = adPlanRepository.save(plan);

        return new AdPlanResponse(plan.getId(),plan.getPlanName());
    }

    @Override
    @Transactional
    public void deleAdPlan(AdPlanRequest request) throws AdException {
        if(!request.deleteValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdPlan plan = adPlanRepository.findByIdAndUserId(request.getId(),request.getUserId());
        if(plan == null){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());
        adPlanRepository.save(plan);

    }
}
