package day03;
/*方法，调用中的参数传递问题：
 * 1.方法参数是基本数据类型（包括String类型），形参改变对实参没有影响
 * 2.方法参数是引用数据类型，形参的改变对实参有影响,因为在内存中，他传递了引用类型
 * 的地址，而不是值，所以改变
 * 三中引用数据类型：数组，类，接口
 */
public class ParameterPass {
  public static void main(String[] args) {
	  /*int a =1;
	  int b=2;
	  change(a,b);
	  System.out.println(a);//1       基本数据类型
	  System.out.println(b);//2
	  */
	  int [] array = {1,2,3,4};
	  System.out.println(array[2]);//3
	  change(array);
	  System.out.println(array[2]);//100
}
  public static void change(int a,int b){
	  a = a+b;
	  b= b+a;
  }
  public static void change(int [] array){
	  array[2] = 100;
  }
}
