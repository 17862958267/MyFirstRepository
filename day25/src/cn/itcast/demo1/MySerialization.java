package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MySerialization {
	public static void main(String[] args) {
		//writeObject();
		readObject();
	}

	private static void readObject() {
		try {
			FileInputStream file = new FileInputStream("E:\\a.txt");
			ObjectInputStream in = new ObjectInputStream(file);
            Object obj = in.readObject();
            if(obj!=null){
            	System.out.println(obj);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeObject() {
		try {
			// 1创建字节输出流
			FileOutputStream file = new FileOutputStream("E:\\a.txt");
			// 2.创建对象输出流的对象，并将字节流传给他
			ObjectOutputStream object = new ObjectOutputStream(file);
			// 3.创建MyPerson对象
			MyPerson p = new MyPerson("绪鑫", 12);
			// 4 利用对象输出流的对象往文件中保存文件
			object.writeObject(p);
			// 5.关闭输出流
			object.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
