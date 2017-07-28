package day01;

public class Operator {
      public static void main(String[] args) {
		  int i=5;
		  int j = i++;//先赋值，后自加
		  System.out.println(i);//6
		  System.out.println(j);//5
		  int a=10;
		  int b = ++a;
		  System.out.println(a);//11
		  System.out.println(b);//11
		  
		  byte m = 10;
		  m = (byte) (m+1);//强制转换，丢失精度
		  
		  int c = 5;
		  int d = 6;
		  System.out.println(c=d);//6
		  System.out.println(c==d);//true
	}
}
