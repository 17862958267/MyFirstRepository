package cn.itcast.demo02;

public class CountOfString {
	public static void main(String[] args) {
		getCount("DFSJHUIrr867$%#^&15lkkik");
		convert("asshuAJSHJHSDgetdg");
	}

	public static void getCount(String str) {
		int upperCount = 0;
		int lowerCount = 0;
		int numberCount = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				numberCount++;
			}
			if (ch >= 'A' && ch <= 'Z') {
				upperCount++;
			}
			if (ch >= 'a' && ch <= 'z') {
				lowerCount++;
			}
		}
		System.out.println("大写字母数" + upperCount);
		System.out.println("小写字母数" + lowerCount);
		System.out.println("数字个数" + numberCount);
	}
	public static void convert(String str){
		String start = str.substring(0,1);
		String end = str.substring(1,str.length()-1);
		String upper = start.toUpperCase();
		String lower = end.toLowerCase();
		System.out.println(upper+lower);
	}

}
