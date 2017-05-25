package cn.qlu.netstore.regist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.qlu.netstore.domain.Customer;
import cn.qlu.netstore.service.Service;
import cn.qlu.netstore.service.ServiceImpl;
@WebServlet("/regist")
public class RegServlet extends HttpServlet {
	private Service service = new ServiceImpl();
    @Override
    public  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Customer c= new Customer();
    	try {
			BeanUtils.populate(c,req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
    	
    	String validateCode = (String) req.getSession().getAttribute("validateCode");
    	String code = req.getParameter("code");
    	if(code.equals(validateCode)){
    	service.regist(c);
    	 resp.getWriter().print("注册成功，两秒后跳转到主页");
    	 resp.sendRedirect(req.getContextPath()+"/header.jsp");
    	}else{
    		req.setAttribute("error", "验证码错误！");
    		req.getRequestDispatcher(req.getContextPath()+"/regist.jsp").forward(req, resp);
    	}
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   	
    	doPost(req, resp);
    }
}
