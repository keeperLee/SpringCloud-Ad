package com.jian.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PreRequestFilter  extends ZuulFilter {
    //过滤器类型，四种pre 、 routing 、post 、error
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //过滤器顺序,值越小，越先被调用
    @Override
    public int filterOrder() {
        return 0;
    }

    //表示是否需要执行过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //filter具体执行的操作
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}
