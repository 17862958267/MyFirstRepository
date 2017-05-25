package cn.studs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns="/stud")
public class LoginFilter implements Filter {
	
	@Override
	public void init(FilterConfig FilterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		     //验证用户是否登陆
				HttpServletRequest req = (HttpServletRequest)request;
				if(req.getSession().getAttribute("user")==null){
					HttpServletResponse resp = (HttpServletResponse) response;
					req.getSession().setAttribute("error", "请先登陆");
					resp.sendRedirect(req.getContextPath()+"/index.jsp");
				}else{
					//放行
					chain.doFilter(request, response);
				}
		
	}

	@Override
	public void destroy() {
		
		
	}

	

}
