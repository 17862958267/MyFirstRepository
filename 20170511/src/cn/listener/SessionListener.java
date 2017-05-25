package cn.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener {
     //监听在线人数
	@Override
	public void sessionCreated(HttpSessionEvent event) {
       ServletContext sc = event.getSession().getServletContext();
		Integer onlineCount = (Integer) sc.getAttribute("onlineCount");
		if(onlineCount==null){
			onlineCount = 1;
		}else{
			onlineCount++;
		}
		sc.setAttribute("onlineCount", onlineCount);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		ServletContext sc = event.getSession().getServletContext();
		Integer onlineCount = (Integer) sc.getAttribute("onlineCount");
		onlineCount--;
		sc.setAttribute("onlineCount", onlineCount);
		
	}

}
