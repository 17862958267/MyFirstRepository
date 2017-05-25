package cn.qlu.netstore.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.netstore.commons.Page;
import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.service.Service;
import cn.qlu.netstore.service.ServiceImpl;
@WebServlet("/showIndex")
public class ShowIndexServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Service service =new ServiceImpl();
   @Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //查询所有的分类
	   List<Category> list = service.queryCategory();
	   req.setAttribute("list", list);
	   //查询所有书籍：分页
	   String num = req.getParameter("num");
	   Page page = service.findBookPageRecords(num);
	   page.setUrl("/showIndex");
	   req.setAttribute("page", page);
	   req.getRequestDispatcher("/listBooks.jsp").forward(req, resp);
   }
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
