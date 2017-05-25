package cn.studs.utils;

import java.util.Map;


public class BeanUtils {
	public static void populate(Object bean,Map<String,? extends Object> param){
		try{
			org.apache.commons.beanutils.BeanUtils.populate(bean, param);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
