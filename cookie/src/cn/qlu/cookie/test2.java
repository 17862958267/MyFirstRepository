package cn.qlu.cookie;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test2")
public class test2 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	LinkedList<String> list = new LinkedList<String>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ss ="";
			if(list.size()==3){
						if(list.contains(id)){
							list.remove(id);
						}else{
							list.removeLast();
						}
					}
					
					list.addFirst(id);
				for (String str : list) {
					ss=ss+str+",";
				}
				ss=ss.substring(0,ss.length()-1);
				System.out.println(ss);
					Cookie cook1 = new Cookie("test1",ss);
					cook1.setMaxAge(24*60*60);
					response.addCookie(cook1);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

