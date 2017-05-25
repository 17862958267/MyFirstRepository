package cn.qlu.netstore.test.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnUtil {
	private static Connection con;
	
	static{
		try{
			Properties prop = new Properties();
			String path = ClassLoader.getSystemResource("a.properties").getPath();
			System.out.println(path);
			prop.load(ClassLoader.getSystemResourceAsStream("a.properties"));
			String driver = prop.getProperty("driver");
			System.out.println(driver);
			String url = prop.getProperty("url");
			System.out.println(url);
			String user = prop.getProperty("user");
			System.out.println(user);
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,"");
			System.out.println(con);
		}catch(Exception e){
			 e.printStackTrace();
		}
		
	}
	   public static Connection getCon(){
		    return con;
	   }

}
