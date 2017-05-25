package cn.mvc.reg;

import cn.mvc.domain.User;

public class RegService {
	private RegDaoJdbc dao = new RegDaoJdbc();
	public void reg(User user){
		dao.reg(user);
	}

}
