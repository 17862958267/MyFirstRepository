package cn.qlu.netstore.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import cn.qlu.netstore.utils.IdGenerator;

public class RandomId {
	@Test
    public void test(){
		String id =IdGenerator.genID();
		System.out.println(id);
	}
	@Test
	public void test1(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String str = sdf.format(now);
	    System.out.println(str);
	}
}
