package com.jian.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  用于创建和更新时候的响应
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanResponse {
    private Long id;
    private String planName;
}
