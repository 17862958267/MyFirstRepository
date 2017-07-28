package day03;
/*
 * 方法的重载:方法的重载与返回值类型无关，它只有两个条件，
 * 一是方法名相同，二是参数个数或参数类型不相同。
 */
public class OverLoads {
       public static void main(String[] args) {
		int sum1 = add(5,6);
		int sum2 = add(3,2,1);
		double sum3 = add(0.1,0.3);
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
	}
       public static int add(int x,int y){
        return x+y;    	    
       }
       public static double add(double x,double y){
    	   return x+y;
       }
       public static int add(int x,int y,int z){
    	   return x+y+z;
       }
}
