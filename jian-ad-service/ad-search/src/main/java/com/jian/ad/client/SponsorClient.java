package com.jian.ad.client;

import com.jian.ad.client.vo.AdPlan;
import com.jian.ad.client.vo.AdPlanGetRequest;
import com.jian.ad.vo.CommonResponse;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//指定访问的路径，调用接口中任意的方法都会去访问这个路径
@FeignClient(value = "eureka-client-ad-sponsor", fallback= SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping(value = "ad-sponsor/get/adPlan",
            method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> getAdPlans(
            @RequestBody AdPlanGetRequest request
            );
}
