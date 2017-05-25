package cn.studs.stud;

import java.util.List;
import java.util.Map;

import cn.studs.domain.Stud;

public class StudService {
	private StudDao dao = new StudDao();
	public Map<String,Object> query(int page,Stud stud){
		return dao.query(page,stud);
	}
}
