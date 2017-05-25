package cn.studs.stud;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.studs.domain.Stud;
import cn.studs.utils.BaseServlet;
import cn.studs.utils.BeanUtils;
import sun.print.resources.serviceui;

@WebServlet("/stud")
public class StudServlet extends BaseServlet {
	private StudService service = new StudService();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String page = req.getParameter("page");
		if (page == null || !page.matches("\\d+")) {
			page = "1";
		}
		int _page = Integer.parseInt(page);
		// 将查询的数据封闭到Stud对象中去
		Stud stud = new Stud();
		if(req.getMethod().equals("GET")){
			stud = (Stud) req.getSession().getAttribute("stud");
			if(stud == null){
				stud = new Stud();
			}
		}else{
		BeanUtils.populate(stud, req.getParameterMap());
		req.getSession().setAttribute("stud", stud);
		}
		// -------
		Map<String, Object> map = service.query(_page, stud);

		List<Stud> list = (List<Stud>) map.get("list");
		Integer pages = (Integer) map.get("pages");
		req.setAttribute("list", list);
		req.setAttribute("pages", pages);

		// 读取开始值和结束的值
		int start = 1;
		int end = 1;
		int pageCount = 10;
		if (pages <= pageCount) {// 不用再对页码分页显示
			end = pages;
		} else {
			if (_page <= (pageCount / 2)) {
				start = 1;
				end = pageCount;
			} else {
				start = _page - (pageCount / 2 - 1);
				end = _page + (pageCount / 2);
				// 如果 结束的页码超出了最大的页码则应该应该向回计算
				if (end > pages) {
					end = pages;// 设置最大值
					start = end - (pageCount - 1);
				}
			}
		}
		System.err.println("start:" + start + "," + end);
		req.setAttribute("start", start);
		req.setAttribute("end", end);

		req.getRequestDispatcher("/WEB-INF/views/studs.jsp").forward(req, resp);
	}
}
