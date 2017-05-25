package cn.mvc.stud;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.mvc.domain.Stud;
import cn.mvc.utils.BaseDao;

public class StudDao extends BaseDao {
	public List<Stud> query() {
		String sql = "select id,name,age,sex,addr from studs";
		List<Stud> list = run.query(sql, new BeanListHandler<Stud>(Stud.class));
		return list;
	}
}
