package cn.mvc.login;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.mvc.domain.User;
import cn.mvc.utils.BaseDao;

public class LoginDaoJdbc extends BaseDao {
	public User login(User user) {
		String sql = "select * from users where name=? and pwd=?";
		user = run.query(sql, new BeanHandler<User>(User.class), user.getName(), user.getPwd());
		return user;
	}
}
