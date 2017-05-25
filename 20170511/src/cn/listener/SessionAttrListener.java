package cn.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class SessionAttrListener implements HttpSessionAttributeListener {
     //¼àÌýµÇÂ¼ÈËÊý
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
	  if(event.getName().equals("user")){
		  ServletContext sc = event.getSession().getServletContext();
		  Integer loginCount = (Integer) sc.getAttribute("loginCount");
		  if(loginCount==null){
			  loginCount = 1;
		  }else{
			  loginCount++;
		  }
		  sc.setAttribute("loginCount", loginCount);
	  }
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if(event.getName().equals("user")){
			ServletContext sc = event.getSession().getServletContext();
			Integer loginCount = (Integer) sc.getAttribute("loginCount");
			loginCount--;
			sc.setAttribute("loginCount", loginCount);
		}
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
		
	}

}
