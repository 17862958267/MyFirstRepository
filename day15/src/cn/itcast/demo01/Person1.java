package cn.itcast.demo01;

public class Person1 extends Object{
	private String name;
	
	//��д�����equals������ʵ���Լ��ıȽϷ�ʽ
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		//�жϴ������Ķ����Ƿ�ΪPerson����
		if(!(obj instanceof Person1)){
			return false;
		}
		//��obj����ת��Ϊperson1,��������
		Person1 p =  (Person1) obj;
		return this.name == p.name;
		
		
	}

}
