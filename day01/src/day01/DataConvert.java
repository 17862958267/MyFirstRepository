package day01;
/**
 * 
 * @author 绪鑫
 * 数据类型从大到小bye--short--integer--long--float-double
 *
 */
public class DataConvert {
           public static void main(String[] args) {
			  double d =1000;//自动类型转换integer--double
			  System.out.println(d);
			  byte a =10;
			  int j = a;//byte自动转为integer
			  System.out.println(j);
			  long m= 10l;
			  int n;
			  n = (int) m;//强制将long型转换为int型
			  
		}
}
