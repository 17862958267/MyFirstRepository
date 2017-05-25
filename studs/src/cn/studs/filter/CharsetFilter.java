package cn.studs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {
	private String charset;
	@Override
	public void init(FilterConfig FilterConfig) throws ServletException {
		charset = FilterConfig.getInitParameter("encoding");
		if(charset==null){
			charset="UTF-8";
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		chain.doFilter(request, response);
		
	}
	@Override
	public void destroy() {
		
		
	}

}
