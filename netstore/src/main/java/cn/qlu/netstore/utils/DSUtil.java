package cn.qlu.netstore.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DSUtil {
	private static DataSource dataSource;
	  static{
		  dataSource = new ComboPooledDataSource();
	  }
	  public static DataSource getDataSource(){
		  return dataSource;
	  }

}
