package cn.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ReqListener implements ServletRequestListener {
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {	
	}
	@Override
	public void requestInitialized(ServletRequestEvent event) {
		ServletContext sc = event.getServletContext();
		Integer accessCount = (Integer) sc.getAttribute("accessCount");
		if(accessCount==null){
			accessCount = 1;
		}else{
		   accessCount++;
		}
		sc.setAttribute("accessCount", accessCount);
	}
}
