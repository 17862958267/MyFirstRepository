package day02;

import org.junit.Test;

/*二位数组
 * int [] [] a = new int[3][4];
 * 
 * */
public class ArrayArrayDemo {
         @Test
         public void test(){
        	 int [] [] a = new int[3][4];
        	 System.out.println(a[1]);//数组的地址
        	 System.out.println(a[2][4]);//数组越界
        	 System.out.println(a[2][3]);//0
         }
         @Test
         public void test1(){
        	 int sum =0;
        	 int [][] a1 = {{1,2,3},{1,1,2},{5,8,0,3}};
        	 for(int i =0;i<a1.length;i++){
        		 for(int j=0;j<a1[i].length;j++){
        			 sum +=a1[i][j];
        		 }
        	 }
        	 System.out.println(sum);
         }
         @Test
         public void test2(){
         //二维数组的定义方式2
         int [][] a2 = new int[3][];
         a2[0] = new int[]{1,2,3};
         a2[1] = new int[]{2,2,8};
         a2[2] = new  int[]{3,9,2};
         System.out.println(a2[1][2]);
         }
}
