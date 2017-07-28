package com.oracle.qlu.compare;

import org.junit.Test;

public class Demo1 {
	
		@Test
		public void test(){
			StringBuffer str = new StringBuffer("MY");
			Long startTime = System.currentTimeMillis();
			for(int i =0;i<10000000;i++){
				str.append("love you");
			}
			Long endTime = System.currentTimeMillis();
			System.out.println(endTime-startTime);
		
	}
   @Test
   public void test1(){
	   StringBuilder str1 = new StringBuilder("My");
	   Long startTime = System.currentTimeMillis();
		for(int i =0;i<10000000;i++){
			str1.append("love you for ever");
		}
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	   
   }
}
