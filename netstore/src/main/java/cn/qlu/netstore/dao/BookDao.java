package cn.qlu.netstore.dao;

import java.util.List;

import cn.qlu.netstore.domain.Book;

public interface BookDao {
	public void addBook(Book book);//添加图书

	public Book findbookById(String bookId);//根据书籍id查找书籍

	public int getTotalRecordsNum();//获取书籍的总记录数

	public List findPageRecords(Integer startIndex, Integer pageSize);

	public int getTotalRecordsNum(String categoryId);

	public List findPageRecords(Integer startIndex, Integer pageSize, String categoryId);
	

}
