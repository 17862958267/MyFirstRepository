package cn.studs.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String methodName = req.getParameter("method");
		if(methodName==null ||  methodName.equals("")){
			methodName="execute";
		}
		try{
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, req,resp);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public abstract void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
