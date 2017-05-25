package cn.qlu.netstore.dao;

import cn.qlu.netstore.domain.Customer;

public interface CustomerDao {
	void regist(Customer c);//客户注册	
    Customer login(Customer c);//客户登录
    Customer logout(String customId);//客户注销
    
}

