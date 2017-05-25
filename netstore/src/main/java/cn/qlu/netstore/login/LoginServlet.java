package cn.qlu.netstore.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;

import cn.qlu.netstore.constant.Constants;
import cn.qlu.netstore.domain.Customer;
import cn.qlu.netstore.service.Service;
import cn.qlu.netstore.service.ServiceImpl;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Service service  = new ServiceImpl();
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Customer c = new Customer();
	try{
	BeanUtils.populate(c, req.getParameterMap());
	}catch(Exception e){
		throw new RuntimeException(e);
	}
	c = service.login(c);
	if(c!=null){
		 req.getSession().setAttribute(Constants.CUSTOMER_LOGIN_FLAG, c);
		 resp.sendRedirect(req.getContextPath()+"/header.jsp");
	}else{
		req.setAttribute("error", "用户名或密码错误！");
		req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req, resp);
	}	 
}
 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		doPost(req, resp);
	}
}
