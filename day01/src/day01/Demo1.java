package day01;

import org.junit.Test;
public class Demo1 {
	@Test
	public void test1(){
		for(int i=1;i<=100;i++){
			if(!String.valueOf(i).contains("8")){
				System.out.println(i);//打印不包括8的1到100的整数
			}
		}
	}
	@Test
	public void  test2(){
		for(int i=0;i<100;i++){
			if(i%10==7 || i/10%10==7){
				continue;
			}
			System.out.println(i);
		}
	}
}

