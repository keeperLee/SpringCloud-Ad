package com.jian.ad.dao.unit_condition;

import com.jian.ad.entity.unit_condition.AdUnitIt;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  单元和兴趣关联的数据操作接口
 */
public interface AdunitItRepository extends JpaRepository<AdUnitIt , Long > {
}
