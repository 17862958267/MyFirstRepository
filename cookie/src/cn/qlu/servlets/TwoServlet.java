package cn.qlu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/two")
public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int times = 1;
		times = Integer.parseInt(req.getParameter("times"));
		String str = "你好同学";
		for (int i = 0; i < times; i++) {
			str += "你好同学" + i;
		}
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print(str);
    }
}
