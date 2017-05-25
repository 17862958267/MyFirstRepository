package cn.qlu.netstore.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.qlu.netstore.domain.Book;
import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.utils.DSUtil;
import cn.qlu.netstore.utils.QueryRunner;

public class BookDaoImpl implements BookDao {
	@Override
	public void addBook(Book book) {
		QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
		String sql = "insert into books(id,name,author,price,path,filename,description,categoryId) values(?,?,?,?,?,?,?,?)";
        try{
        	qr.update(sql,book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getPath(),book.getFilename(),book.getDescription(),book.getCategory().getId());
        }catch(Exception e){
		   throw new RuntimeException(e);
        }
	}

	@Override
	public Book findbookById(String bookId) {
		try{
			QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
			String sql = "select * from books where id=?";
			Book book = qr.query(sql, new BeanHandler<Book>(Book.class),bookId);
			if(book!=null){
				Category c = qr.query("select * from categorys where id=(select categoryId from categorys where id=?)", new BeanHandler<Category>(Category.class),bookId);
			    book.setCategory(c);
			}			
			return book;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public int getTotalRecordsNum() {
		try{
			QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
			String sql = "select count(*) from books";
			//long
			Object obj = qr.query(sql, new ScalarHandler(1));
			Long num =  (Long) obj;
			return num.intValue();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List findPageRecords(Integer startIndex, Integer pageSize) {
		try{
			QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
			String sql = "select * from books limit ?,?";
			List<Book> books = qr.query(sql, new BeanListHandler<Book>(Book.class),startIndex,pageSize);
			return books;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalRecordsNum(String categoryId) {
		try{
			QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
			String sql = "select count(*) from books where categoryId=?";
			//long
			Object obj = qr.query(sql, new ScalarHandler(1),categoryId);
			Long num =  (Long) obj;
			return num.intValue();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List findPageRecords(Integer startIndex, Integer pageSize, String categoryId) {
		try{
			QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
			String sql = "select * from books where categoryId=? limit ?,?";
			List<Book> books = qr.query(sql, new BeanListHandler<Book>(Book.class),categoryId,startIndex,pageSize);
			return books;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
