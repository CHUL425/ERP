package com.miraeasset.biz.common.util;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ConvertUtils {
	private ConvertUtils() {}
	
	// VO -> MAP
	public static Map<String, Object> convertToMap(Object obj) {
		try {
			if (Objects.isNull(obj)) {
				return Collections.emptyMap();
			}
			Map<String, Object> convertMap = new HashMap<>();
			
			Field[] fields = obj.getClass().getDeclaredFields();
			
			for (Field field : fields) {
				field.setAccessible(true);
				convertMap.put(field.getName(), field.get(obj));
			}
			return convertMap;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	// List<VO> -> List<Map>
	public static List<Map<String, Object>> convertToMaps(List<?> list) {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}
		return list.stream().map(ConvertUtils::convertToMap).collect(Collectors.toList());
	}
	
	// Map -> VO
	public static <T> T convertToValueObject(Map<String, Object> map, Class<T> type) {
		try {
			if (Objects.isNull(type)) {
				throw new NullPointerException("Class cannot be null");
			}
			if (Objects.isNull(map) || map.isEmpty()) {
				throw new IllegalAccessException("map is null or empty");
			}
			
			T instance = type.getConstructor().newInstance();
			Field[] fields = type.getDeclaredFields();
			
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				for (Field field : fields) {
					if (entry.getKey().equals(field.getName())) {
						field.setAccessible(true);

						Object value = Objects.isNull(entry.getValue()) && field.getType().isPrimitive()
								? getDefaultValue(field.getType())
								: map.get(field.getName());

						// 타입 별 케이스 처리
						if(field.getType().getName().equals("long")){
							try{
								value = Long.valueOf(entry.getValue().toString());
							} catch(NumberFormatException nex) {
								value = 0;
							}
						}

						field.set(instance, value);

						break;
					}
				}
			}
			return instance;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	// List<Map> -> List<VO>
	public static <T> List<T> convertToValueObjects(List<Map<String, Object>> list, Class<T> type) {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}
		List<T> convertList = new ArrayList<T>();
		
		for (Map<String, Object> map : list) {
			convertList.add(ConvertUtils.convertToValueObject(map, type));
		}
		return convertList;
	}
	
	
	private static Object getDefaultValue(Class<?> type) {
		// TODO Auto-generated method stub
		switch (type.getName()) {
			case "byte" :
			case "short":
			case "int"  :
				return 0;
			case "long"   : return 0L;	
			case "float"  : return 0.0f;	
			case "double" : return 0.0d;	
			case "char"   : return '\u0000';	
			case "boolean": return false;	
		}
		return null;
	}
	
}
