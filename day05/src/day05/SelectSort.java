package day05;

/**
 * 排序方法，规则：比较大小，位置交换 数组的选择排序：数组的每个元素都进行比较， 数组的冒泡排序：数组中的相邻元素进行比较
 * 
 * @author Administrator
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] a = { 12, 6, 27, 20, 18, 0, 9 };
		selectSort(a);
		printArray(a);
	}
	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	private static void selectSort(int[] a) {
		/*
		 * 定义方法,实现数组的选择排序 返回值: 没有 参数: 数组 实现步骤: 1.嵌套循环实现排序 外循环,控制的是一共比较了多少次
		 * 内循环,控制的是每次比较了多少个元素 2. 判断元素的大小值 小值,存储到小的索引
		 */
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

	}
}
