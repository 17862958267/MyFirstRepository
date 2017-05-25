package cn.demo;

import org.junit.Test;

import cn.studs.utils.DSUtils;
import cn.studs.utils.QueryRunner;

public class Demo01 {
	@Test
	public void test1() throws Exception{
		String sql = "insert into studs(id,name,sex,age,addr) values(?,?,?,?,?)";
		QueryRunner run = new QueryRunner(DSUtils.dataSource());
		String id = "S";
		for(int i=1;i<234;i++){
			String _id = "00"+i;
			_id = id+_id.substring(_id.length()-3, _id.length());
			run.update(sql,_id,"Jack"+i,""+i%2,i*3,"China");
		}
	}
}
