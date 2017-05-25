package cn.qlu.netstore.dao;

import java.util.List;

import cn.qlu.netstore.domain.Order;

public interface OrderDao {

	void save(Order o);//保存订单

	Order findByNum(String ordernum);//根据订单id查询订单

	List<Order> findByCustomer(String customerid);//根据客户查询订单

}
