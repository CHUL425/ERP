package com.miraeasset.biz.common.util;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 공통 유틸
 */
public class ObjectCopyUtil {

	private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);
	/**
	 * copyFields : 두객체의 같은 필드항목값 복사 유틸
	 */
	public static void copyFields(Object source, Object destination){
		// 소스 객체와 대상 객체의 클래스를 가져옵니다.
		Class<?> sourceClass = source.getClass();
		Class<?> destinationClass = destination.getClass();
		
		// 소스 객체의 모든 필드를 가져옵니다.
		Field[] fields = sourceClass.getDeclaredFields();
		
		
		// 각 필의에 대해 값을 복사합니다.
		for( Field field : fields ) {
			// 필드 이름을 가져옵니다.
			String fieldName = field.getName();
			
			try {
				// 필드에 접근할 수 있도록 설정
				field.setAccessible(true);
				
				// 대상 객체에서 필드를 찾습니다.
				Field destinationField = destinationClass.getDeclaredField(fieldName);
				
				// 대상 객체의 필드에 소스 객체의 값을 복사한다.
				destinationField.setAccessible(true);
				destinationField.set(destination, field.get(source));
				
			} catch (NoSuchFieldException e ) {
				//e.printStackTrace();
				//log.info("NoSuchFieldException ["+fieldName+"]["+destinationClass.getCanonicalName()+"]");
			} catch (IllegalAccessException e) {
				e.printStackTrace();				
			}
		}
	}
	
	/**
	 * copyFields : 두객체의 같은 필드항목값 복사 유틸
	 */
	public static void copyListFields(Object sourceList, Object destinationList){
		
		
	}

}
