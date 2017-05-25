package cn.qlu.netstore.manage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.service.Service;
import cn.qlu.netstore.service.ServiceImpl;
@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
     private Service service = new ServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Category c = new Category();
	try {
		BeanUtils.populate(c, req.getParameterMap());
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
	c.setName(req.getParameter("name"));
	c.setDescription(req.getParameter("description"));
	service.addCategory(c);
	req.getRequestDispatcher("/common/message.jsp").forward(req, resp);	
}
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
}
