package com.org.api.Acceptance_Test.common;

import java.util.Map;

public class CommonCatalog {
	private static CommonCatalog instance= new CommonCatalog();
	private ThreadLocal<Map<String,Object>> catalog= new ThreadLocal<Map<String,Object>>();
	
	
	
	public static CommonCatalog getInstance(){
		return instance;
	}
}
