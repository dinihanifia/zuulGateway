package com.zuul.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zuul.gateway.constant.HttpConstant;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CustomFilter extends ZuulFilter {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(CustomFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = ctx.getRequest();
        String operasi = httpServletRequest.getHeader(HttpConstant.Header.OPERASI);
        if(operasi.isBlank()){
            writeResponse(ctx,400,"Header gak ada");
            return null;
        }
//        ctx.addZuulRequestHeader("OPERASI", "operasi");
//            log.info("customFilter : "+String.format("%s request to %s", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString()));
        return operasi;
    }

    private void writeResponse(RequestContext ctx, int code, String message){
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(200);
    }
}
