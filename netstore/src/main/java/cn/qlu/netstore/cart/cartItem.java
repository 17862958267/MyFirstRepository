package cn.qlu.netstore.cart;

import java.io.Serializable;

import cn.qlu.netstore.domain.Book;

public class cartItem implements Serializable {
          /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Book book;
          private int quantity;//本项数量
          private float money;//本项金额
		public Book getBook() {
			return book;
		}
		public void setBook(Book book) {
			this.book = book;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public float getMoney() {
			return money;
		}
		public void setMoney(float money) {
			this.money = money;
		}
		public cartItem(Book book) {
			super();
			this.book = book;
		}
          
}
