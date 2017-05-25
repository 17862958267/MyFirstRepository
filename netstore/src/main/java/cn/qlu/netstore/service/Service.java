package cn.qlu.netstore.service;

import java.util.List;

import cn.qlu.netstore.commons.Page;
import cn.qlu.netstore.domain.Book;
import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.domain.Customer;
import cn.qlu.netstore.domain.Order;

public interface Service {
	void regist(Customer c);//注册客户
    Customer login(Customer c);//客户登录	
    Customer logout(String customerId);//客户注销
    void addCategory(Category c);//添加分类
    List<Category> queryCategory();//查询所有分类
    Category findById(String categoryId);//根据类别id查询类别
    void addBook(Book book);//添加图书,注意，如果book关联的category为空，就要抛出异常
    Page findBookPageRecords(String num);//根据用户要看的号码查询书籍的分页，返回page对象。
    Page findBookPageRecords(String num,String categoryId);
    Book findBookById(String bookId);//根据id查询一本书，返回book还有分类
    void genOrder(Order o);//生成订单
    Order findOrderByNum(String OrderNm);//根据订单号查询订单
    List<Order> findCustomerOrders(Customer c);//查询客户的订单


}
