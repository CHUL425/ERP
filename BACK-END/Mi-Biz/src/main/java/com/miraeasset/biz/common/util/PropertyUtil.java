package com.miraeasset.biz.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class PropertyUtil {
	
	private static final Logger log = LoggerFactory.getLogger(PropertyUtil.class);
	
	public static String getProperty(String propertyName) {
		return getProperty(propertyName, null);
	}
	
	public static String getProperty(String propertyName, String defaultValue) {
		String value = defaultValue;
		
		ApplicationContext applicationContext = ApplicationContextServe.getApplicationContext();
		if(applicationContext.getEnvironment().getProperty(propertyName) == null) {
			log.warn(propertyName + " properties was not loaded.");
		} else {
			value = applicationContext.getEnvironment().getProperty(propertyName).toString();
		}
		
		return value;
	}
}
