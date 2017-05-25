package cn.qlu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TokenFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//判断是否存在_token_请求
		if(req.getMethod().equals("POST")){
			//获取数据
			String token = req.getParameter("_token_");
			System.out.println(token);
			if(token!=null){
				//从session中取值
				String sToken = (String) req.getSession().getAttribute("_token_");
			    //比较
				if(token.equals(sToken)){
					req.getSession().removeAttribute("_token_");
					chain.doFilter(request, response);
				}else{
					HttpServletResponse resp = (HttpServletResponse) response;
                    resp.setContentType("text/html;charset=UTF-8");
                    resp.getWriter().print("不可以重复提交");
				}
			}else{
				chain.doFilter(request, response);
			}
				
			}else{
				chain.doFilter(request, response);
		}
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	

}
