package com.jian.ad.service;

import com.jian.ad.exception.AdException;
import com.jian.ad.vo.*;

public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws  AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws  AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws  AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws  AdException;
}
