package cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import cn.domain.Stud;
@WebServlet("/stud3")
public class StudServlet3 extends HttpServlet {
         @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setCharacterEncoding("UTF-8");
        	 String data = req.getParameter("data");
          List<Stud> list = new ArrayList<Stud>();
          Random r =  new Random();
          int a = r.nextInt(50);
          for(int i=1;i<a;i++){
        	  list.add(new Stud("Jack"+i,i*2));
          }
          String str = JSONArray.toJSONString(list);
          resp.setContentType("text/plain;charset=UTF-8");
          resp.getWriter().println(str);
         }
         @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        }
}
