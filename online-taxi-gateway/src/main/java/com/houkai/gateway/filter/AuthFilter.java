package com.houkai.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 鉴权filter
 */
@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        System.out.println("来源URI: "+requestURI);
        //只有此接口/api-passenger/api-passenger-gateway-test/hello才被拦截
        //localhost:9000/api-passenger/api-passenger-gateway-test/hello
        String checkUri = "/api-passenger/api-passenger-gateway-test/hello";
        if (checkUri.equalsIgnoreCase(requestURI))return true;
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("拦截");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("Authorization");
        //如果token是1234,通过
        String defaulttoken="1234";
        if (StringUtils.isNotBlank(token) && defaulttoken.equals(token))System.out.println("校验通过");
        else {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }
}
