package cn.studs.reg;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.studs.domain.User;
import cn.studs.utils.BeanUtils;

import cn.studs.utils.MD5Password;

@WebServlet("/reg")
public class RegServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		User user = new User();
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		user.setId(id);
		user.setPwd(MD5Password.md5(user.getId(), user.getId()));
		BeanUtils.populate(user, req.getParameterMap());
		String randomCode = (String) req.getSession().getAttribute("validateCode");
		String code = req.getParameter("code");
		if(code.equals(randomCode)){
			//注册成功后重定向到登录界面
		user = new RegService().reg(user);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}else{
			req.setAttribute("error", "验证码错误！");
			req.getRequestDispatcher("/reg.jsp").forward(req, resp);
		}
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

}
