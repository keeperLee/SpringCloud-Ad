package com.jian.ad.dao;

import com.jian.ad.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  推广单元数据操作接口
 */
public interface AdUnitRepository  extends JpaRepository<AdUnit , Long> {

    //根据单元所属的计划id和单元名查询出单元
    AdUnit findByPlanIdAndUnitName(Long PlanId, String unitName);

    //根据单元状态查询多个单元
    List<AdUnit> findAllByUnitStatus( Integer unitStatus);
}
