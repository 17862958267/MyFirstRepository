package day03;
/*�����������еĲ����������⣺
 * 1.���������ǻ����������ͣ�����String���ͣ����βθı��ʵ��û��Ӱ��
 * 2.���������������������ͣ��βεĸı��ʵ����Ӱ��,��Ϊ���ڴ��У�����������������
 * �ĵ�ַ��������ֵ�����Ըı�
 * ���������������ͣ����飬�࣬�ӿ�
 */
public class ParameterPass {
  public static void main(String[] args) {
	  /*int a =1;
	  int b=2;
	  change(a,b);
	  System.out.println(a);//1       ������������
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
