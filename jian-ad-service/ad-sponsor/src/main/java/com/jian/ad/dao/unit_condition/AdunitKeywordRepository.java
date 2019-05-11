package com.jian.ad.dao.unit_condition;

import com.jian.ad.entity.unit_condition.AdUnitKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  单元和关键词关联的数据操作接口
 */
public interface AdunitKeywordRepository extends JpaRepository<AdUnitKeyword , Long > {

}
