package cn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first")
public class FirstServlet extends HttpServlet{
           @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //获取用户的参数
        	   String name = req.getParameter("name");
           //返回用户提交的数据
        	   Date date = new Date();
        	   SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        	   sdf.format(date);
        	   resp.setContentType("text/plain;charset=UTF-8");
        	   resp.getWriter().print("你好"+name+",当前时间为："+date.toString());
           }

          @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        }
}
