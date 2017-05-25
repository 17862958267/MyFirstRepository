package cn.qlu.netstore.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.service.Service;
import cn.qlu.netstore.service.ServiceImpl;
@WebServlet("/queryCategory")
public class QueryCategory extends HttpServlet {
	private Service service = new ServiceImpl();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Category> list = new ArrayList<Category>();
       list = service.queryCategory();
       req.getSession().setAttribute("list", list);
       req.getRequestDispatcher("/manage/listCategory.jsp").forward(req, resp);
    }
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
}
