package cn.studs.stud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import cn.studs.domain.Stud;
import cn.studs.utils.BaseDao;

public class StudDao extends BaseDao {
	public Map<String,Object> query(int page,Stud stud) {
		Map<String, Object> map = new HashMap<>();
		int pageSize = 10;//每次最多显示10行
		
		
		
		String sql = "select count(1) from studs";
		String where = " where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		//开始组成查询的条件
		if(StringUtils.isNotEmpty(stud.getName())){
			where+=" and name like ?";
			list.add("%"+stud.getName()+"%");
		}
		if(stud.getAge()!=null)
		{
			where+=" and age=?";
			list.add(stud.getAge());
		}
		if(StringUtils.isNotEmpty(stud.getSex())){
			where+=" and sex=?";
			list.add(stud.getSex());
		}
		if(StringUtils.isNotEmpty(stud.getAddr())){
			where+=" and addr like ?";
			list.add(stud.getAddr());
		}
		
		int rows = run.query(sql+where, new ScalarHandler<Number>(),list.toArray()).intValue();
		//
		int pages = rows/pageSize+(rows%pageSize==0?0:1);
		//声明查询页面的开始limit 0,10  :  10,10 2
		int start = (page-1)*pageSize;
		sql = "select * from studs "+where+" limit "+start+","+pageSize;
		
		List<Stud> list2 = run.query(sql, new BeanListHandler<>(Stud.class),list.toArray());
		map.put("list",list2);
		map.put("pages",pages);
		return map;
	}
}
