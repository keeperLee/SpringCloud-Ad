package com.jian.ad.service;

import com.jian.ad.vo.CreativeRequest;
import com.jian.ad.vo.CreativeResponse;

public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request)  ;
}
