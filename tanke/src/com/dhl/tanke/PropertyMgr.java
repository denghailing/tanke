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
// 单例：PropertyMgr, ResourceMgr
//策略：Strategy   a: Comparable b:Compatator  c:tanke fire
public class PropertyMgr {
	//该类里面存了好多键值对。提供方法访问这些键值对
	static Properties proper = new Properties();
	static{
		try {
			proper.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Object get(String key){
		if(proper == null) return null;
		return proper.get(key);
	}
	public static int getInt(String key){
		if(proper == null) return 0;
		return Integer.parseInt((String)proper.get(key));
	}
	public static String getString(String key){
		if(proper == null) return "";
		return (String)proper.get(key);
	}
}
