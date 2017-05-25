package cn.qlu.netstore.dao;

import java.util.List;

import cn.qlu.netstore.domain.Category;

public interface CategoryDao {
	public void addCategory(Category c);//添加分类
	public List<Category> queryCategory();//查询所有分类
	Category findById(String categoryId);//根据categoryId查询类别

}
