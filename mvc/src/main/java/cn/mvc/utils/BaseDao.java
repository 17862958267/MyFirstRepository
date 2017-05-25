package cn.mvc.utils;
public class BaseDao {
	protected QueryRunner run;
	public BaseDao() {
		run = new QueryRunner(DSUtils.dataSource());
	}
}
