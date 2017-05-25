package cn.studs.reg;

import cn.studs.domain.User;

public class RegService {
	private RegDao dao = new RegDao();
	public User reg(User user){
		 dao.reg(user);
		return user;
	}

}
