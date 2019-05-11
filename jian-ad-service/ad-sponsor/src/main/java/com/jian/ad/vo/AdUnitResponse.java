package com.jian.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 *  封装单元返回信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitResponse {

    private Long id;
    private String unitName;

}
