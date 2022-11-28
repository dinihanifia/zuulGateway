package com.zuul.gateway.filter;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostFilter extends ZuulFilter{
	private static org.slf4j.Logger log = LoggerFactory.getLogger(PostFilter.class);
	
	@Override
	public String filterType() {
		return "post";
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
	public Object run() {
		HttpServletResponse httpServletResponse = RequestContext.getCurrentContext().getResponse();
		log.info("postFilter : "+String.format("response's contents type is %s", httpServletResponse.getStatus()));
		return null;
	}
	
}
