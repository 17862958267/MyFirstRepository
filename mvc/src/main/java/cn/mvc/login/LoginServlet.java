package cn.mvc.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mvc.domain.User;
import cn.mvc.utils.BeanUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		User user = new User();
		BeanUtils.populate(user, req.getParameterMap());
		user = new LoginService().login(user);
		if (user == null) {
			// 如果登录没有成功，则再重新去登录页面，显示用户名或密码错误
			req.setAttribute("error", "用户名或密码错误!");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			// 登录成功
			req.getSession().setAttribute("user", user);

			resp.sendRedirect(req.getContextPath() + "/stud");
		}
	}
}
