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
			// 1�����ֽ������
			FileOutputStream file = new FileOutputStream("E:\\a.txt");
			// 2.��������������Ķ��󣬲����ֽ���������
			ObjectOutputStream object = new ObjectOutputStream(file);
			// 3.����MyPerson����
			MyPerson p = new MyPerson("����", 12);
			// 4 ���ö���������Ķ������ļ��б����ļ�
			object.writeObject(p);
			// 5.�ر������
			object.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
