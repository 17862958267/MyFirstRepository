package day02;
import org.junit.Test;
public class DemoArray {
	@Test
	public void test(){
		int [] a;
		a = new int[4];
		a[0] =1;
		a[1] =2;
		a[2] =3;
		a[3] =4;
		System.out.println(a[0]);
		System.out.println(a);//打印的是数组的地址
	}
	@Test
	public void test2(){
		//数组的静态初始化
		int [] array = new int[]{1,2,3,5};
	    int [] array1 = {1,2,3,4,5,6};
	    System.out.println(array[0]);
	    System.out.println(array1[1]);
	}
	@Test
	public void test3(){
		//打印数组元素的最大值
		int [] a ={10,58,29,4,59,30,59};
		int max = a[0];
		for(int i =0;i<a.length;i++){
			if(a[i]>a[0]){
				max = a[i];
			}
		}
		System.out.println(max);
	}
	//一维数组的遍历与累加和
	@Test
	public void test4(){
		int sum = 0;
		int [] array = {1,2,3,4,5};
		for(int i = 0;i<array.length;i++){
			sum += array[i];
		}
		System.out.println(sum);
	}
}
