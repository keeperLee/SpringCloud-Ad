package com.jian.ad.dao;

import com.jian.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  推广计划数据操作接口
 */
public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {

    //根据计划id和计划所属用户的id查询出计划
    AdPlan findByIdAndUserId(Long id , Long userId);

    //根据给出的计划id列表和所属用户的id查询出计划列表
    List<AdPlan> findAllByIdInAndUserId(List<Long> ids, Long userId);

    //根据所属用户的id和计划名获取计划
    AdPlan findUserIdAndPlanName(Long userId, String planName);

    //根据状态查询出多个计划
    List<AdPlan> findAllByPlanStatus(Integer status);
}
