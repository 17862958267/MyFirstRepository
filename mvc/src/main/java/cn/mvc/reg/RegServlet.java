package cn.mvc.reg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mvc.domain.User;

@WebServlet("/reg")
public class RegServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 req.setCharacterEncoding("UTF-8");
	 String name =req.getParameter("name");
	 String pwd = req.getParameter("pwd");
	 String pwd1= req.getParameter("pwd1");
	 User user = new User();
	 user.setName(name);
	 user.setPwd(pwd);
	 new RegService().reg(user);
	 resp.setContentType("text/html;charset=UTF-8");
	 resp.getWriter().print("注册成功了，现在去<a href='"+req.getContextPath()+"/index.jsp'>登录</a>");
	 }
		
	
	
}
