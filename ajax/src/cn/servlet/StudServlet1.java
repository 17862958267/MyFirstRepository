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

import com.thoughtworks.xstream.XStream;

import cn.domain.Stud;
@WebServlet("/stud1")
public class StudServlet1 extends HttpServlet {
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
           resp.setContentType("text/xml;charset=UTF-8");
           //利用第三方工具类xstream将对象装维xml文本
           XStream x = new XStream();
           x.alias("studs", List.class);
           x.alias("stud", Stud.class);
           String sb = x.toXML(list);
           resp.getWriter().println(sb);
         }
         @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        }
}
