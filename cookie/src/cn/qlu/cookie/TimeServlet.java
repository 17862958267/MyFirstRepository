package cn.qlu.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //确定是否为第一次访问
    	resp.setContentType("text/html;charset=utf-8");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	String curTime = sdf.format(new Date());
    	String lastTime = null;
    	Cookie[] cookies =req.getCookies();
    	if(cookies!=null){
    		for(Cookie c:cookies){
    			if(c.getName().equals("lastTime")){
    				//不是第一次访问,获取cookie的值
    				lastTime = c.getValue();
    				resp.getWriter().print("欢迎回来，你上次访问的时间为："+lastTime+"\t\n"+"当前时间为："+curTime);
    				//更新cookie
    				c.setValue(curTime);
    				//发送给浏览器保存
    				c.setMaxAge(1*24*60*60);
    				resp.addCookie(c);
    				break;
    			}
    		}
    	}
    	if(cookies==null || lastTime==null){
    		//第一次访问，显示当前时间到浏览器
    		PrintWriter out = resp.getWriter();
    		out.print("你是首次访问本网站，当前时间为："+curTime);
    		//创建cookie
    		Cookie cookie = new Cookie("lastTime",curTime);
    		cookie.setMaxAge(1*24*60*60);
    		//发送cookie到浏览器保存
    		resp.addCookie(cookie);
    	}
    
    
    
    
    
    
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }
}
