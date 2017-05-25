package cn.qlu.netstore.dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.qlu.netstore.domain.Customer;
import cn.qlu.netstore.utils.DSUtil;
public class CustomerDaoImpl implements CustomerDao {
	protected QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
	@Override
	public void regist(Customer c) {
		try{
		String sql ="insert into customers(id,username,password,nickname,phonenum,address,email) values(?,?,?,?,?,?,?)";
		qr.update(sql,c.getId(),c.getUsername(),c.getPassword(),c.getNickname(),c.getPhonenum(),c.getAddress(),c.getEmail());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	@Override
	public Customer login(Customer c) {
		try{
		String sql ="select * from customers where username=? and password=?";
		c = qr.query(sql, new BeanHandler<Customer>(Customer.class),c.getUsername(),c.getPassword());
		return c;
	}catch(Exception e){
		throw new RuntimeException(e);	
	}
	}
	@Override
	public Customer logout(String customId) {
		try{
			String sql = "select * from customers where id=?";
			return qr.query(sql, new BeanHandler<Customer>(Customer.class),customId);			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
