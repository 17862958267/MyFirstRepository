package cn.qlu.variables;

public class Person {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
	}
	public void speak(){
		String name="ÀîËÄ";
		int age = 20;
		System.out.println("name is:"+name+"age is:"+age);
		System.out.println("name is:"+this.name+"age is:"+this.age);
	}
	

}
