package cn.qlu.netstore.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.utils.DSUtil;

public class CategoryDaoImpl implements CategoryDao {
	protected QueryRunner qr = new QueryRunner(DSUtil.getDataSource());
	@Override
	public void addCategory(Category c) {
		try{
			String sql = "insert into categorys(id,name,description) values(?,?,?)";
			qr.update(sql,c.getId(),c.getName(),c.getDescription());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
		
	}
	@Override
	public List<Category> queryCategory() {
		try{
		String sql = "select * from categorys";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	@Override
	public Category findById(String categoryId) {
		try{
			String sql = "select * from categorys where id=?";
			return qr.query(sql, new BeanHandler<Category>(Category.class),categoryId);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
    
}
