package com.jian.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 *   既可以用来创建，也可以用来更新、删除推广计划
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanRequest {

    //创建的时候不使用id，更新的时候使用
    private Long id;
    //表示推广计划属于哪个用户
    private Long userId;
    private String planName;
    //需要做反序列化，将String类型装换成java.util.Date类型
   private String startDate;
   private String endDate;

   //判断是否可以创建，要求要有用户id并且计划名不能为空,开始时间和结束时间不能为空
   public boolean createValidate(){
       return userId != null
               && StringUtils.isEmpty(planName)
               && StringUtils.isEmpty(startDate)
               && StringUtils.isEmpty(endDate);
   }

   //判断是否可以更新,判断id和userId是否为空
    public boolean updateValidate(){
       return id != null && userId != null;
    }

    //判断是否可以删除,判断id和userId是否为空
    public boolean deleteValidate(){
        return id != null && userId != null;
    }
}
