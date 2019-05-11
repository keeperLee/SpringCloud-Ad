package com.jian.ad.dao.unit_condition;

import com.jian.ad.entity.unit_condition.AdUnitDistrict;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  单元地域关联的数据操作接口
 */
public interface AdunitDistrictRepository extends JpaRepository<AdUnitDistrict ,Long> {
}
