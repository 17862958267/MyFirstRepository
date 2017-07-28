package day05;
/*
 * 计算1+3+5.。。+99
 */
public class CumSum {
        public static void main(String[] args) {
	          int sum =0;
	          for(int i=1;i<100;i++){
	        	  if(i%2==0){
	        		  sum += i;
	        	  }
	          }
	          System.out.println(sum);
}
}
