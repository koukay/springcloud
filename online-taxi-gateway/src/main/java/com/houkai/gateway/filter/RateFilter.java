package com.houkai.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RateFilter extends ZuulFilter {
    /**
     *
     *每秒1个令牌,实际通过压测获得
     */
    private static final RateLimiter RATE_LIMITER= RateLimiter.create(1);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 限流要最早
     * @return
     */
    @Override
    public int filterOrder() {
        return -10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //拿不到令牌马上返回
        if (!RATE_LIMITER.tryAcquire()){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }
}
