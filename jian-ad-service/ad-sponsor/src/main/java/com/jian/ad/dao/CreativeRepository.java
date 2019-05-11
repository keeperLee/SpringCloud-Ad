package com.jian.ad.dao;

import com.jian.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  创意数据操作接口
 */
public interface CreativeRepository extends JpaRepository<Creative , Long> {



}
