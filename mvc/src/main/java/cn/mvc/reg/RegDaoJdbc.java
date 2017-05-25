package cn.mvc.reg;

import java.util.UUID;

import cn.mvc.domain.User;

public class RegDaoJdbc extends cn.mvc.utils.BaseDao {
	//注册用户
	public void reg(User user){
		user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		String sql ="insert into users(id,name,pwd) values(?,?,?)";
		run.update(sql,user.getId(),user.getName(),user.getPwd());
	}

}
