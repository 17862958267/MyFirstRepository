package cn.qlu.netstore.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.netstore.constant.Constants;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getSession().removeAttribute(Constants.CUSTOMER_LOGIN_FLAG);
	resp.sendRedirect(req.getContextPath()+"/header.jsp");
}
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   doPost(req, resp);
	}
}
