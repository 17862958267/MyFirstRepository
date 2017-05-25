package cn.qlu.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class test extends HttpServlet{
	
		private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String che = request.getParameter("che");
			if("1".equals(che)){
				Cookie cook = new Cookie("test",name+","+pw);
				cook.setMaxAge(24*60*60);
				response.addCookie(cook);
			}
			
			
			
		
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}

