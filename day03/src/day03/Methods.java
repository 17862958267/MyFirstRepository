package day03;

public class Methods {
/*
 * ��ӡ3*3����
 */
	public static void main(String[] args) {
		printRect();
	}
	public static void printRect(){
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				System.out.print("*"); 
			}
		System.out.println();
		}
	}
}
