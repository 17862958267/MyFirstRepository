package cn.qlu.netstore.utils;

import java.util.UUID;

public class IdGenerator {
	public static String genID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
