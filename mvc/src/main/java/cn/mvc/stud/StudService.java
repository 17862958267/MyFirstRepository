package cn.mvc.stud;

import java.util.List;

import cn.mvc.domain.Stud;

public class StudService {
	private StudDao dao = new StudDao();

	public List<Stud> query() {
		return dao.query();
	}
}
