package com.miraeasset.biz.common.util;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {
	private final static Logger logger = LoggerFactory.getLogger(StringUtils.class);
	
	public final static String STRING_EMPTY = "";

	/**
	 * text가 null 또는 empty면, EMPTY 문자열을 리턴한다.
	 * text가 null 또는 empty가 아니면, text를 그대로 리턴한다.
	 * @param text 체크할 문자열
	 * @return 입력 문자열 또는 빈 문자열
	 */
	public static String empty(String text) {
		return isEmpty(text) ? STRING_EMPTY : text;
	}

	/**
	 * text가 null or empty 문자열이면, emptyText를 리턴하고,
	 * not null or not empty 문자열이면, text를 그대로 리턴한다.
	 * @param text 체크할 문자
	 * @param emptyText 입력 문자열이 빈문자열인 경우 대신 리턴할 문자열
	 * @return emptyText 또는 text
	 */
	public static String empty(String text, String emptyText) {
		return isEmpty(text) ? emptyText : text;
	}

	/**
	 * text가 null 이거나 길이가 0이면 true를 리턴한다.
	 * 그 이외는 false이다.
	 *
	 * @param text 체크할 문자열
	 * @return boolean
	 */
	public static boolean isEmpty(String text) {
		return (text==null || text.length()==0);
	}

	/**
	 * <p> str의 길이가 chunk보다 작은 경우 왼쪽부터 pad문자로 채운다.</P>
	 *
	 * @param str   input string
	 * @param chunk chunk size (bytes...)
	 * @param pad   padding char
	 * @return String
	 */
	public static String lPad(Object string, int chunk, char pad) {
		String str = string.toString();
		if( isEmpty(str) ) return pad(chunk, pad);

		int byLen = str.getBytes().length;
		if( byLen > chunk) {
			byte[] bytes = str.getBytes();
			return (new String(bytes, 0, chunk));
		} else {
			StringBuffer result = new StringBuffer(chunk);
			while(byLen < chunk) {
				result.append(pad);
				byLen++;
			}
			result.append(str);
			return result.toString();
		}
	}

	/**
	 * If str's length is less then chunk, fill pad char from right to left.
	 *
	 * @param str   input string
	 * @param chunk chunk size
	 * @param pad   padding char
	 * @return String
	 */

	public static String rPad(String str, int chunk, char pad) {
		if( isEmpty(str) ) return pad(chunk, pad);

		int byLen = str.getBytes().length;
		if( byLen > chunk) {
			return str.substring(0, chunk);
		} else {
			StringBuffer result = new StringBuffer(chunk);
			result.append(str);
			while(byLen < chunk) {
				result.append(pad);
				byLen++;
			}
			return result.toString();
		}
	}

	/**
	 * encoding 에 맞게끔 변환하여 리턴.
	 *
	 * @param str
	 * @param length
	 * @param pad
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String rPadB(String str, int length, char pad, String encoding) throws Exception {
		String a = rPad(str, length, pad);

		return new String(a.getBytes(encoding), 0, length, encoding);
	}


	/**
	 * Make string with padding character.
	 * @param chunk chunk
	 * @param pad   padding character
	 * @return String
	 */
	public static String pad(int chunk, char pad) {
		StringBuffer result = new StringBuffer(chunk);
		for(int i = 0; i < chunk; i++) {
			result.append(pad);
		}
		return result.toString();
	}

	/**
	 * 두 문자열을 비교한다.
	 * null and empty 문자열을 동일한 문자열로 처리한다.
	 *
	 * @param str1
	 * @param str2
	 * @return true/false
	 */
	public static boolean equal(String text1, String text2) {
		if( empty(text1).equals(empty(text2))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * String.startsWidth를 대/소문자를 무시하고 찾는다.
	 *
	 * @param text 대상 문자열
	 * @param prefix 찾을 문자열
	 */
	public static boolean startsWithIgnoreCase(String text, String prefix) {
		if (text == null || prefix == null) {
			return false;
		}
		if (text.startsWith(prefix)) {
			return true;
		}
		if (text.length() < prefix.length()) {
			return false;
		}
		String lcStr = text.substring(0, prefix.length()).toLowerCase();
		String lcPrefix = prefix.toLowerCase();
		return lcStr.equals(lcPrefix);
	}

	/**
	 * Object 를 logger로 출력한다.
	 * List 형이면 List로 Class 형이면 Calss로 출력한다.
	 *
	 * @param obj Object
	 */
	public static void toLogger(Object obj) {
		if (obj instanceof List) {
			List<?> listObj = (List<?>) obj;
			for (int idx = 0; idx < listObj.size(); idx++) {
				logger.debug(ToStringBuilder.reflectionToString(listObj.get(idx), ToStringStyle.MULTI_LINE_STYLE));
			}
		} else {
			logger.debug(ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE));
		}

	}


	/**
	 * Null 이거나 공백이면 true 를 리턴한다.
	 *
	 * @param str 문자열
	 * @return
	 */
	public static boolean isNullOrBlank(String str) {
		if (str == null) {
			return true;
		} else {
			if (str.trim().equals("")) return true;
		}
		return false;
	}
}
