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
@WebServlet("/stud2")
public class StudServlet2 extends HttpServlet {
         @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           req.setCharacterEncoding("UTF-8");
           //模拟数据库查询学生列表
           List<Stud> list = new ArrayList<Stud>();
           Random r = new Random();
           int a =r.nextInt(50);
           for(int i=1;i<a;i++){
           list.add(new Stud("Jack"+i,2*i));
           }
           resp.setContentType("text/plain;charset=UTF-8");
           //手工将list集合转成json
           String str = JSONArray.toJSONString(list);
           resp.getWriter().println(str);
         }
         @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        }
}
