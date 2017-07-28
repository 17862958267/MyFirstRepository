package day05;

public class ASCIIDemo {
	public static void main(String[] args) {
		char upperCase ='A';
		char lowerCase ='a';
		for(int i = 0;i<26;i++){
			System.out.println("大写字母依次为"+upperCase+",小写字母依次为"+lowerCase);
			upperCase++;
			lowerCase++;
		}
		
	}

}
