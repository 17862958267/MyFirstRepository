package cn.studs.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.studs.domain.User;
import cn.studs.utils.BeanUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	User user = new User();
	BeanUtils.populate(user,req.getParameterMap());
	user = new LoginService().login(user);
	if(user==null){
		req.setAttribute("error", "用户名或者密码错误");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}else{
		//重定向
		req.getSession().setAttribute("user", user);//将用户登陆的信息保存到session
		resp.sendRedirect(req.getContextPath()+"/stud");
		
	}
	
    }
}
