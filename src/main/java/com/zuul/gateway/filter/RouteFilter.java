package com.zuul.gateway.filter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class RouteFilter extends ZuulFilter{
	private static org.slf4j.Logger log = LoggerFactory.getLogger(RouteFilter.class);
	
	@Override
	public String filterType() {
		return "route";
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
	public Object run(){
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest = ctx.getRequest();
		log.info("routeFilter : "+String.format("%s request to %s", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString()));
		return null;
	}

}
