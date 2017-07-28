package day04;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*利用集合实现随机点名器
 * 功能：存储，打印，随机一个学生
 */
public class RandomCallName {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		addStudent(list);
		printStudent(list);
		randomCall(list);
	}
	public static void addStudent(ArrayList<Student> list){//存储全班学生名字
		           Scanner sc = new Scanner(System.in);
		           for(int i=0;i<3;i++){
		        	   Student s =  new Student();
		        	   System.out.println("存储第"+i+"个同学的姓名");
		        	   s.name = sc.next();
		        	   System.out.println("存储第"+i+"个同学的年龄"); 
		        	   s.age = sc.nextInt();
		        	   list.add(s);
		           }
		}
	 public static void printStudent(ArrayList<Student> list){//打印全班人信息
		 for(int i=0;i<list.size();i++){
			 Student s = list.get(i);
			 System.out.println("姓名"+s.name+",年龄"+s.age);
		 }
	 }
	 public static void randomCall(ArrayList<Student> list){//随机取出一个学生信息
		   Random  r = new Random();
		   int index = r.nextInt(list.size());
		   Student s = list.get(index);
		   System.out.println("点到的人是"+s.name+"年龄"+s.age);
	 }
	}


