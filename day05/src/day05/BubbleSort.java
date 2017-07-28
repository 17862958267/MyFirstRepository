package day05;
/**
 * 冒泡排序：相邻的两个元素进行比较，小的往前，大的往后
 * @author Administrator
 *
 */
public class BubbleSort {
        public static void main(String[] args) {
			int [] a ={9,20,-1,1,4,2,8,};
			for(int i=0;i<a.length-1;i++){
				for(int j=0;j<a.length-i-1;j++){
					if(a[j]>a[j+1]){
					int temp =a[j];
					a[j] =a[j+1];
					a[j+1]=temp;
				}
				}
			}
			for(int i=0;i<a.length;i++){
				System.out.println(a[i]);
			}
		}
}
