package cn.itast.demo02;

public class TestA {
	public static void main(String[] args) {
		System.out.println(A.count);
		A a = new A();
		int b = a.num;
		// System.out.println(A.num);编译报错，因为静态环境中不能访问非静态变量,但是我们可以通过
		//创建该类的实例来访问非静态成员变量
	}
}
