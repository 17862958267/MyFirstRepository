package cn.qlu.netstore.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.qlu.netstore.dao.OrderDao;
import cn.qlu.netstore.domain.Order;
import cn.qlu.netstore.domain.OrderItem;
import cn.qlu.netstore.utils.DSUtil;
import cn.qlu.netstore.utils.QueryRunner;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void save(Order o) {
		try{
		QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
		String sql ="insert into orders(ordernum,quantity,money,status,customerId) values(?,?,?,?,?)";
		qr.update(sql,o.getOrdernum(),o.getQuantity(),o.getMoney(),o.getStatus(),o.getCustomer().getId());
		//保存订单项的信息
		List<OrderItem> items = o.getItems();
		for(OrderItem item:items){
			qr.update("insert into orderItems(id,quantity,price,bookId,ordernum) values(?,?,?,?,?)",item.getId(),item.getQuantity(),item.getPrice(),item.getBook().getId(),o.getOrdernum());
		}
		}catch(Exception e){
			 throw new RuntimeException(e);
		}
	}

	@Override
	public Order findByNum(String ordernum) {
		QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
		String sql ="select * from orders where ordernum=?";
		return qr.query(sql, new BeanHandler<Order>(Order.class),ordernum);
	}

	@Override
	public List<Order> findByCustomer(String customerId) {
		try{
		QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
        String sql = "select * from orders where customerId=? order by ordernum desc";
		return (List<Order>) qr.query(sql, new BeanHandler<Order>(Order.class),customerId);
	}catch(Exception e){
		throw new RuntimeException(e);
	}
	}
}
