package day01;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		  Random r = new Random();
		  int a = r.nextInt(100);
		  Scanner sc = new Scanner(System.in);
		  System.out.println("请输入一个1-100的整数");
		 while(true){
			 int in = sc.nextInt();
            if(in==a){
            	System.out.println("猜对了！");
            	break;
            }else if(in>a){
            	System.out.println("猜大了");
            }else{
            	System.out.println("猜小了");
            }
		 }
	}

}
