package day05;
/*数组的指针思想：
 * 就是数组的索引，指针可以随时指向数组的任意所索引
 * 大指针：数组的最大索引
 * 小指针：数组的最小索引
 * 实现数组的逆序
 * 
 * 
 */
public class ReverseSort {
	 public static void main(String[] args) {
		int [] a = {2,6,-5,7,10,20,69};
		//创建数组的逆序方法
		reverse(a);
		//遍历输出数组
		printArray(a);
		}
	private static void printArray(int[] a) {
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	private static void reverse(int[] a) {
		//定义数组的最小与最大下标，以及临时变量
		for(int min=0,  max = a.length-1;min<max;max--,min++){
			int temp = a[max];
			a[max] = a[min];
			a[min] = temp;
		}
	}
	}


