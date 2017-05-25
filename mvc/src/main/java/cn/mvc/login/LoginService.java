package cn.mvc.login;

import cn.mvc.domain.User;

public class LoginService {
	private LoginDaoJdbc dao = new LoginDaoJdbc();
	public User login(User user){
		return dao.login(user);
	}
}
