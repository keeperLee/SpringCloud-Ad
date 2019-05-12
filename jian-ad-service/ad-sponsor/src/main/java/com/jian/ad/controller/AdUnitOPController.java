package com.jian.ad.controller;

import com.alibaba.fastjson.JSON;
import com.jian.ad.exception.AdException;
import com.jian.ad.service.IAdUnitService;
import com.jian.ad.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdUnitOPController {

    private final IAdUnitService adUnitService;

    @Autowired
    public AdUnitOPController(IAdUnitService adUnitService) {
        this.adUnitService = adUnitService;
    }

    @PostMapping("/create/adUnit")
    public AdUnitResponse createUnit(@RequestBody AdUnitRequest request) throws AdException{
        log.info("ad-sponsor: createUnit -> {}", JSON.toJSONString(request));
        return adUnitService.createUnit(request);
    };

    @PostMapping("/create/unitKeyword")
    public AdUnitKeywordResponse createUnit(@RequestBody AdUnitKeywordRequest request) throws AdException{
        log.info("ad-sponsor: createUnitKeyword -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitKeyword(request);
    };

    @PostMapping("/create/unitIt")
    public AdUnitItResponse createUnit(@RequestBody AdUnitItRequest request) throws AdException{
        log.info("ad-sponsor: createUnitIt -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitIt(request);
    };

    @PostMapping("/create/unitDistrict")
    public AdUnitDistrictResponse createUnit(@RequestBody AdUnitDistrictRequest request) throws AdException{
        log.info("ad-sponsor: createUnitDistrict -> {}", JSON.toJSONString(request));
        return adUnitService.createUnitDistrict(request);
    };

    @PostMapping("/create/creativeUnit")
    public CreativeUnitResponse createUnit(@RequestBody CreativeUnitRequest request) throws AdException{
        log.info("ad-sponsor: createCreativeUnit -> {}", JSON.toJSONString(request));
        return adUnitService.createCreativeUnit(request);
    };



}
