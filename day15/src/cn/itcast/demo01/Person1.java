package cn.itcast.demo01;

public class Person1 extends Object{
	private String name;
	
	//重写父类的equals方法，实现自己的比较方式
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		//判断传进来的对象是否为Person类型
		if(!(obj instanceof Person1)){
			return false;
		}
		//将obj向下转型为person1,访问属性
		Person1 p =  (Person1) obj;
		return this.name == p.name;
		
		
	}

}
