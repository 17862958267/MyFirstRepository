package cn.qlu.netstore.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qlu.netstore.commons.Page;
import cn.qlu.netstore.service.Service;
import cn.qlu.netstore.service.ServiceImpl;
@WebServlet("/queryBooks")
public class QueryBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service = new ServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String num = req.getParameter("num");
    	Page page = service.findBookPageRecords(num);
    	page.setUrl("/queryBooks");
    	req.setAttribute("page", page);
    	req.getRequestDispatcher("/manage/listBooks.jsp").forward(req, resp);
    	
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
}
