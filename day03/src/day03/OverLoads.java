package day03;
/*
 * ����������:�����������뷵��ֵ�����޹أ���ֻ������������
 * һ�Ƿ�������ͬ�����ǲ���������������Ͳ���ͬ��
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
