package com.zuul.gateway.filter;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class ErrorFilter extends ZuulFilter{
	private static org.slf4j.Logger log = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public String filterType() {
		return "error";
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
		log.info("errorFilter : "+String.format("response status is %d", httpServletResponse.getStatus()));
		return null;
	}
}
