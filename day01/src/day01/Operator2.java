package day01;
/**
 * 
 * @author 绪鑫
 *逻辑运算符,对两个boolean 类型做运算，结果也是boolean型
 *&：两边只要有一个为false,结果为false
 *|:    两边只要有一个为true,结果为true
 *^:    两边不同为true,相同为false
 *!:     取反
 *&&:短路与     一边是false,另一边不运行 
 *||:  短路或     一边是true,另一边不运行
 */
public class Operator2 {
  public static void main(String[] args) {
	          System.out.println(true&false);//false
	          System.out.println(true|false);//true
	          System.out.println(true^false);//true
	          System.out.println(false^false);//false
	          System.out.println("----------------------------------------");
	          int i = 3;
              int j = 4;
              System.out.println(i>j&&++j>2);
              System.out.println(i);
              System.out.println(j);
              
  }  
}
