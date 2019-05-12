package com.jian.ad.controller;

import com.alibaba.fastjson.JSON;
import com.jian.ad.service.ICreativeService;
import com.jian.ad.vo.CreativeRequest;
import com.jian.ad.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CreativeOPController {

    private final ICreativeService creativeService;

    @Autowired
    public CreativeOPController(ICreativeService creativeService) {
        this.creativeService = creativeService;
    }

    public CreativeResponse createCreative(@RequestBody CreativeRequest request){
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
