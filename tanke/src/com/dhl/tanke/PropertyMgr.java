/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.io.IOException;
import java.util.Properties;

import org.junit.experimental.theories.Theories;

/**
 * 
 * @author DHL
 * @version 2020年5月31日
 */
//将该类设计成单例模式：在内存中如果需要某个类的对象，在程序上保证有且仅有一个该类的对象。
public class PropertyMgr {
	//该类里面存了好多键值对。提供方法访问这些键值对
	static Properties properties = new Properties();
	static{
		try {
			properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Object get(String key){
		if(properties == null) return null;
		return properties.get(key);
	}
	//getInt(key)
	//getString(key)
//	public static void main(String[] args){
//		System.out.println(properties.get("initTankeCount"));
//	}
}
