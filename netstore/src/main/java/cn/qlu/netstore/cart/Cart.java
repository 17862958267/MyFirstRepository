package cn.qlu.netstore.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.qlu.netstore.domain.Book;

public class Cart implements Serializable {
	//key对应书籍的id，值对应购物项，一次购物一项对应一本书
     private Map<String,cartItem> items = new HashMap<String,cartItem>();
     private int totalQuantity;//总数量
     private float totalMoney;//总金额
	public Map<String, cartItem> getItems() {
		return items;
	}
	public void setItems(Map<String, cartItem> items) {
		this.items = items;
	}
	public int getTotalQuantity() {
		totalQuantity = 0;
		for(Map.Entry<String, cartItem> item :items.entrySet()){
			totalQuantity += item.getValue().getQuantity();
		}
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public float getTotalMoney() {
		totalMoney = 0;
		for(Map.Entry<String, cartItem> item :items.entrySet()){
			totalMoney += item.getValue().getMoney();
		}
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	//向购物车添加一本书
	public void addBook(Book book){
		if(items.containsKey(book.getId())){
			//有对应的购物项
			cartItem item = items.get(book.getId());
			item.setQuantity(item.getQuantity()+1);
		}else{
			cartItem item = new cartItem(book);
			item.setQuantity(1);
			items.put(book.getId(), item);
		}
	}
     



}
