package cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/validate")
public class RegServlet extends HttpServlet{
           @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name =req.getParameter("name");
        resp.setContentType("text/plain;charset=UTF-8");
          if(name.startsWith("J")){
        	  resp.getWriter().println("0");
          }else{
        	  resp.getWriter().println("1");
          }
           }        
           @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        }
}
