package day02;

import java.util.Random;

/*
 * 随机点名器
 * */
public class RandomCallName {
       public static void main(String[] args) {
		Random a = new Random();
		int index;
		index = a.nextInt(3);
		String [] name = {"张三","李四","王五","赵六"};
		for(int i = 0;i<name.length;i++){
		}
		System.out.println(name[index]);
	}
}
