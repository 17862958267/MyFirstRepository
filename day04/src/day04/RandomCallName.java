package day04;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*���ü���ʵ�����������
 * ���ܣ��洢����ӡ�����һ��ѧ��
 */
public class RandomCallName {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		addStudent(list);
		printStudent(list);
		randomCall(list);
	}
	public static void addStudent(ArrayList<Student> list){//�洢ȫ��ѧ������
		           Scanner sc = new Scanner(System.in);
		           for(int i=0;i<3;i++){
		        	   Student s =  new Student();
		        	   System.out.println("�洢��"+i+"��ͬѧ������");
		        	   s.name = sc.next();
		        	   System.out.println("�洢��"+i+"��ͬѧ������"); 
		        	   s.age = sc.nextInt();
		        	   list.add(s);
		           }
		}
	 public static void printStudent(ArrayList<Student> list){//��ӡȫ������Ϣ
		 for(int i=0;i<list.size();i++){
			 Student s = list.get(i);
			 System.out.println("����"+s.name+",����"+s.age);
		 }
	 }
	 public static void randomCall(ArrayList<Student> list){//���ȡ��һ��ѧ����Ϣ
		   Random  r = new Random();
		   int index = r.nextInt(list.size());
		   Student s = list.get(index);
		   System.out.println("�㵽������"+s.name+"����"+s.age);
	 }
	}


