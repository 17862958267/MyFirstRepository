package cn.qlu.netstore.test;

import java.sql.Connection;

import java.sql.Statement;


import org.junit.Test;

import cn.qlu.netstore.test.utils.ConnUtil;


public class JDBCTest {
	@Test
	public void test(){
		try{
		 Connection con = ConnUtil.getCon();
		 System.out.println(con);
         String sql = "insert into categorys(id,name,description) values('1','绪鑫','a')";	
         Statement st = con.createStatement();
         st.executeUpdate(sql);
		}catch(Exception e){
            throw new RuntimeException(e);		
		}
	}

}
