package cn.qlu.netstore.service;

import java.util.List;

import cn.qlu.netstore.commons.Page;
import cn.qlu.netstore.dao.BookDao;
import cn.qlu.netstore.dao.BookDaoImpl;
import cn.qlu.netstore.dao.CategoryDao;
import cn.qlu.netstore.dao.CategoryDaoImpl;
import cn.qlu.netstore.dao.CustomerDao;
import cn.qlu.netstore.dao.CustomerDaoImpl;
import cn.qlu.netstore.dao.OrderDao;
import cn.qlu.netstore.dao.OrderDaoImpl;
import cn.qlu.netstore.domain.Book;
import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.domain.Customer;
import cn.qlu.netstore.domain.Order;
import cn.qlu.netstore.utils.IdGenerator;

public class ServiceImpl implements Service {
    private CustomerDao customerDao = new CustomerDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
	@Override
	public void regist(Customer c) {
		c.setId(IdGenerator.genID());
		customerDao.regist(c);
	}
	@Override
	public Customer login(Customer c) {
		
		return customerDao.login(c);	
	}
	@Override
	public Customer logout(String customerId) {
         return customerDao.logout(customerId);
		
	}
	@Override
	public void addCategory(Category c) {
		c.setId(IdGenerator.genID());
		categoryDao.addCategory(c);	
	}
	@Override
	public List<Category> queryCategory() {
		return categoryDao.queryCategory();
	}
	@Override
	public Category findById(String categoryId) {
		return categoryDao.findById(categoryId);
	}
	@Override
	public void addBook(Book book) {
		if(book==null){
			throw new IllegalArgumentException("the book can not be null");
		}
		if(book.getCategory()==null){
			throw new IllegalArgumentException("the book's category can not be null");
		}
		book.setId(IdGenerator.genID());
		 bookDao.addBook(book);
		
	}
	@Override
	public Page findBookPageRecords(String num) {
		int pageNum =1;
		if(num!=null&&!num.equals("")){
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNum = bookDao.getTotalRecordsNum();
		Page page = new Page(pageNum,totalRecordsNum);
		List records = bookDao.findPageRecords(page.getStartIndex(),page.getPageSize());
		page.setRecords(records);
		return page;
	}
	@Override
	public Page findBookPageRecords(String num, String categoryId) {
		int pageNum = 1;
		if(num!=null&&!num.equals("")){
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNum = bookDao.getTotalRecordsNum(categoryId);
		Page page = new Page(pageNum, totalRecordsNum);
		List records = bookDao.findPageRecords(page.getStartIndex(),page.getPageSize(),categoryId);
		page.setRecords(records);
		return page;
	}
	@Override
	public Book findBookById(String bookId) {
		return bookDao.findbookById(bookId);
	}
	@Override
	public void genOrder(Order o) {
		if(o.getCustomer()==null){
			throw new IllegalArgumentException("订单所属的客户信息没有");
		}
		if(o.getItems()==null||o.getItems().size()==0){
			throw new IllegalArgumentException("订单中没有订单项，不需要生成订单");
		}
		orderDao.save(o);//向数据库中保存订单
	}
	@Override
	public Order findOrderByNum(String ordernum) {
		return orderDao.findByNum(ordernum);
	}
	@Override
	public List<Order> findCustomerOrders(Customer c) {
		return orderDao.findByCustomer(c.getId());
	}
	

}
