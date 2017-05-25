package cn.studs.reg;
import cn.studs.domain.User;
import cn.studs.utils.BaseDao;
public class RegDao extends BaseDao{
	//注册用户
	public void reg(User user){
		String sql = "insert into users(id,name,pwd) values(?,?,?)";
		run.update(sql,user.getId(),user.getName(),user.getPwd()); 
	}

}
