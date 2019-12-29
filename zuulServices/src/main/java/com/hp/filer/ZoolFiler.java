package com.hp.filer;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component//生成对象
public class ZoolFiler extends ZuulFilter {
    @Override
    public String filterType() {
        //请求发出之前过滤
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //请求头之前查看参数
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        //需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //请求上下文
        RequestContext current=RequestContext.getCurrentContext();
        //获取request请求
        HttpServletRequest request=current.getRequest();
        //设置请求参数
        String token=request.getParameter("access-token");
        if(StringUtils.isBlank(token)){
            current.setSendZuulResponse(false);
            current.setResponseStatusCode(403);
        }
        return null;
    }
}
