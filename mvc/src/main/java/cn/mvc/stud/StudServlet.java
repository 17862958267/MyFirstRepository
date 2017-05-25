package cn.mvc.stud;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mvc.domain.Stud;

@WebServlet("/stud")
public class StudServlet extends HttpServlet {
	private StudService service = new StudService();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Stud> list = service.query();
		req.setAttribute("list",list);
		req.getRequestDispatcher("/jsps/show.jsp").forward(req, resp);
	}
}
