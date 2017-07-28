package cn.itcast.demo03;

public class StringBufferTest {
	public static void main(String[] args) {
		// 将数组int[] a = new int[]{12,34,78,99}转化为[12,34,78,99]
		int[] a = new int[] { 12, 34, 78, 99 };
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1) {
				sb.append(a[i] + ",");
			} else {
				sb.append(a[i] + "]");
			}
		}
		System.out.println(sb.toString());
	}

}
