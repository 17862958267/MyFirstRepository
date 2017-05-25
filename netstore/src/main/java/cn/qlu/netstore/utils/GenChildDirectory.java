package cn.qlu.netstore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenChildDirectory {
	public static String genChildDirectory(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String str = sdf.format(now);
	    return str;
	}

}
