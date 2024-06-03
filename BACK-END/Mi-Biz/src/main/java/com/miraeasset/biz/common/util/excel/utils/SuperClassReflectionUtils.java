package com.miraeasset.biz.common.util.excel.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class SuperClassReflectionUtils {
	
	private SuperClassReflectionUtils() {}
	
	public static List<Field> getAllFields(Class<?> cls) {
		List<Field> fields = new ArrayList<>();
		for (Class<?> clsInClasses : getAllClassesIncludingSuperClasses(cls, true)) {
			fields.addAll(Arrays.asList(clsInClasses.getDeclaredFields()));
		}
		return fields;
	}
	
	public static Annotation getAnnotation(Class<?> cls, Class<? extends Annotation> targetAnnotation) {
		for (Class<?> clsInClasses : getAllClassesIncludingSuperClasses(cls, false)) {
			if (clsInClasses.isAnnotationPresent(targetAnnotation)) {
					return clsInClasses.getAnnotation(targetAnnotation); 
			}
		}
		return null;
	}
	
	public static Field getField(Class<?> cls, String name) throws Exception {
		for (Class<?> clsInClasses : getAllClassesIncludingSuperClasses(cls, false)) {
			for (Field field : clsInClasses.getDeclaredFields()) {
				if (field.getName().equals(name)) {
					return clsInClasses.getDeclaredField(name); 
				}
			}
		}
		throw new NoSuchFieldException();	
	}
	
	private static List<Class<?>> getAllClassesIncludingSuperClasses(Class<?> cls, boolean fromSuper) {
		// TODO Auto-generated method stub
		List<Class<?>> classes = new ArrayList<>();
		while (cls != null) {
			classes.add(cls);
			cls = cls.getSuperclass();
		}
		
		if (fromSuper) {
			Collections.reverse(classes);
		}
		
		return classes;
	}
}
