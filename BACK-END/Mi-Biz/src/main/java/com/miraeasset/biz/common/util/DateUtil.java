package com.miraeasset.biz.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

public class DateUtil
{
	/**
	 * 바이트 체크 영문 1byte, 한글 2byte, 특문 1byte
	 * @param val 체크할 값
	 * @param ChkByte 기준 바이트수
	 * @return
	 */
	public static boolean byteCheck(String val, int ChkByte) {
		
		if (StringUtils.isEmpty(val)) {return true;}
		
		int en = 0;
		int ko = 0;
		int etc = 0;
		
		char[] valChar = val.toCharArray();
		for (int i = 0; i < valChar.length; i++) {
			if (valChar[i] >= 'A' && valChar[i] <= 'a') {
				en++;
			/* [가-힣]  */	
			} else if (valChar[i] >= '\uAC00' && valChar[i] <= '\uD7A3') {
				ko++;
				ko++;
			} else {
				etc++;
			}
		}
		
		int valByte = en + ko + etc;
		if (valByte > ChkByte) {
			return false;
		} else {
			return true;
		}
	}
	
	public static java.util.Date getCurrentDate()
	{
		try
		{
			SimpleTimeZone tz = new SimpleTimeZone(32400000, "KST");
			TimeZone.setDefault(tz);
		} catch (NullPointerException tz) {
			tz.printStackTrace();
		} catch (Exception tz) {
			tz.printStackTrace();
		}
		return new java.util.Date();
	}

	public static String getTodayString(String date_format)
	{
		String dateStr = "";
		try {
			java.util.Date   date = getCurrentDate();
			SimpleDateFormat sdf = new SimpleDateFormat(date_format, Locale.KOREAN);
			dateStr = sdf.format(date);
		} catch (NullPointerException date) {
			date.printStackTrace();
		} catch (Exception date) {
			date.printStackTrace();}

		return dateStr;
	}

	public static String getNowTime(String pattern){
		SimpleDateFormat formatter = new SimpleDateFormat (pattern,Locale.KOREAN);
		String dateString = formatter.format(new Date());
		return dateString;
	}

	public static String getDateString(java.util.Date dt, String date_format)
	{
		String dateStr = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(date_format, Locale.KOREAN);
			dateStr = sdf.format(dt);
		} catch (NullPointerException sdf) {
			sdf.printStackTrace();
		} catch (Exception sdf) {
			sdf.printStackTrace();
		}

		return dateStr;
	}

	public static String getDateString(java.util.Date dt, String date_format, Locale locale)
	{
		String dateStr = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(date_format, locale);
			dateStr = sdf.format(dt);
		} catch (NullPointerException sdf) {
			sdf.printStackTrace();
		} catch (Exception sdf) {
			sdf.printStackTrace();
		}

		return dateStr;
	}

	public static Timestamp getSqlDateTime(java.util.Date dt)
	{
		java.util.Date d = null;
		if (dt == null)
			d = new java.util.Date();
		else
			d = dt;

		return new Timestamp(d.getTime());
	}

	public static java.sql.Date getSqlDate(java.util.Date dt)
	{
		java.util.Date d = null;
		if (dt == null)
			d = new java.util.Date();
		else
			d = dt;

		return new java.sql.Date(d.getTime());
	}

	public static Time getSqlTime(java.util.Date dt)
	{
		java.util.Date d = null;
		if (dt == null)
			d = new java.util.Date();
		else
			d = dt;

		return new Time(d.getTime());
	}

	public static String stringToDateString(String d, String format)
	{
		java.util.Date ch = null;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			ch = sdf.parse(d);
		} catch (NullPointerException sdf) {
			sdf.printStackTrace();
		} catch (Exception sdf) {
			sdf.printStackTrace();
		}

		return getDateString(ch, format);
	}

	public static String stringToDateString(String d, String oldformat, String newformat)
	{
		java.util.Date ch = null;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(oldformat);
			ch = sdf.parse(d);
		} catch (NullPointerException sdf) {
			sdf.printStackTrace();
		} catch (Exception sdf) {
			sdf.printStackTrace();
		}

		return getDateString(ch, newformat);
	}

	public static java.util.Date getDate(String d, String format)
	{
		java.util.Date ch = null;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.KOREAN);
			ch = sdf.parse(d);
		} catch (NullPointerException sdf) {
			sdf.printStackTrace();
		} catch (Exception sdf) {
			sdf.printStackTrace();
		}

		return ch;
	}

	public static java.util.Date getDate(String d, String format, Locale locale)
	{
		java.util.Date ch = null;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
			ch = sdf.parse(d);
		} catch (NullPointerException sdf) {
			sdf.printStackTrace();
		} catch (Exception sdf) {
			sdf.printStackTrace();
		}

		return ch;
	}

	public static boolean betweenDate(String first, String second, String format)
	{
		boolean flag = false;
		java.util.Date start = null;
		java.util.Date end = null;
		java.util.Date current = null;
		try
		{
			start = getDate(first, format);
			end = getDate(second, format);
			current = getDate(getTodayString(format), format);
		} catch (NullPointerException pe) {
			return false;
		} catch (Exception pe) {
			return false;
		}

		if (((start.before(current)) && (end.after(current))) || (start.equals(current)) || (end.equals(current)))
			flag = true;

		return flag;
	}

	public static java.util.Date add(java.util.Date date, int amount, int field)
	{
		Calendar c = Calendar.getInstance(Locale.KOREAN);
		c.setTime(date);

		c.add(field, amount);
		return c.getTime();
	}

	public static String[] getWeek(int year, int month, int date)
	{
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar g = new GregorianCalendar(year, month - 1, date);
		g.add(10, 1);
		int dayOfWeek = g.get(7);
		String[] week = new String[7];

		week[0] = getFullDate(g, 1 - dayOfWeek, format);
		week[1] = getFullDate(g, 1, format);
		week[2] = getFullDate(g, 1, format);
		week[3] = getFullDate(g, 1, format);
		week[4] = getFullDate(g, 1, format);
		week[5] = getFullDate(g, 1, format);
		week[6] = getFullDate(g, 1, format);

		return week;
	}

	private static String getFullDate(Calendar g, int i, Format format) {
		g.add(5, i);

		return format.format(g.getTime());
	}

	/**
	 * 일자의 형식이 맞는지 비교한다.
	 * 년, 월, 일을 int로 따로 입력. isDate( 2003, 12, 12)
	 */
	private static boolean isDate( int year, int month, int date ){
		int maxDate = getDayCount( year, month );
		if( year < 0 )
			return false;
		if( !( 1 <= month && month <= 12 ) )
			return false;
		if( !( 1 <= date && date <= maxDate ) )
			return false;
		return true;
	}
	/**
	 * 일자의 형식이 맞는지 비교한다.
	 * 20030101 비교. isDate( 20030101 )
	 */
	public static boolean isDateChk( String strDate ){
		int year = 0;
		int month = 0;
		int date = 0;
		try{
			year = Integer.parseInt( strDate.substring( 0, 4 ) );
			month = Integer.parseInt( strDate.substring( 4, 6 ) );
			date = Integer.parseInt( strDate.substring( 6, 8 ) );
		} catch (NullPointerException _e) {
			return false;
		} catch( Exception _e ){
			return false;
		}
		return isDate( year, month, date );
	}

	/**
	 * 지정한달의 일자 수를 반환한다.
	 * 파라메터 : 년도-2003 , 달-9(12)
	 */
	private static int getDayCount( int year, int month ){
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		year += ( month - 1 ) / 12;
		month = ( month % 12 == 0 ) ? 12 : month % 12;
		if( year < 1900 ){
			return getDayCount( year += 100, month );
		} else if( year > 9999 ){
			return getDayCount( year -= 100, month );
		}
		if( month == 2 ){
			if( year % 400 == 0 )
				return 29;
			else if( year % 100 == 0 )
				return days[month - 1];
			else if( year % 4 == 0 )
				return 29;
		}
		return days[month - 1];
	}


	/**
	 * 현재 년월 - YYYYMM
	 */
	public static String getMonth() {
		String month;

		Calendar cal = Calendar.getInstance(Locale.getDefault());

		StringBuffer buf = new StringBuffer();

		buf.append(Integer.toString(cal.get(Calendar.YEAR)));
		month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		if (month.length() == 1)
			month = "0" + month;

		buf.append(month);

		return buf.toString();
	}

	/**
	 * 현재 년월일 - YYYYMMDD
	 */
	public static String getDate() {
		String month, day;

		Calendar cal = Calendar.getInstance(Locale.getDefault());

		StringBuffer buf = new StringBuffer();

		buf.append(Integer.toString(cal.get(Calendar.YEAR)));
		month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		if (month.length() == 1)
			month = "0" + month;
		day = Integer.toString(cal.get(Calendar.DATE));
		if (day.length() == 1)
			day = "0" + day;

		buf.append(month);
		buf.append(day);

		return buf.toString();
	}

	/**
	 * 현재 시간 - HHMISS
	 */
	public static String getTime() {
		String hour, min, sec;

		Calendar cal = Calendar.getInstance(Locale.getDefault());

		StringBuffer buf = new StringBuffer();

		hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
		if (hour.length() == 1)
			hour = "0" + hour;

		min = Integer.toString(cal.get(Calendar.MINUTE));
		if (min.length() == 1)
			min = "0" + min;

		sec = Integer.toString(cal.get(Calendar.SECOND));
		if (sec.length() == 1)
			sec = "0" + sec;

		buf.append(hour);
		buf.append(min);
		buf.append(sec);

		return buf.toString();
	}

	/**
	 * 특정날짜에 일자를 더한 값
	 *
	 * @param dateTime
	 *            YYYYMMDD
	 * @param plusDay
	 *            더할 일자
	 * @return 특정날짜에 일자를 더한 값
	 */
	public static String getAddDay(String dateTime, int plusDay) {

		if (dateTime == null)
			return "";

		if (dateTime.length() == 8)
			dateTime += "000000";

		if (dateTime.equals("99991231")) {
			return "99991231000000";
		}

		if (dateTime.equals("99991231235959")) {
			return "99991231235959";
		}

		int y = Integer.parseInt(dateTime.substring(0, 4));
		int m = Integer.parseInt(dateTime.substring(4, 6));
		int d = Integer.parseInt(dateTime.substring(6, 8));

		java.util.GregorianCalendar sToday = new java.util.GregorianCalendar();
		sToday.set(y, m - 1, d);
		sToday.add(GregorianCalendar.DAY_OF_MONTH, plusDay);

		int day = sToday.get(GregorianCalendar.DAY_OF_MONTH);
		int month = sToday.get(GregorianCalendar.MONTH) + 1;
		int year = sToday.get(GregorianCalendar.YEAR);

		String sNowyear = String.valueOf(year);
		String sNowmonth = "";
		String sNowday = "";

		if (month < 10)
			sNowmonth = "0" + String.valueOf(month);
		else
			sNowmonth = String.valueOf(month);

		if (day < 10)
			sNowday = "0" + String.valueOf(day);
		else
			sNowday = String.valueOf(day);

		return sNowyear + sNowmonth + sNowday;

	}

	/**
	 * 특정날짜에 달을 더한 값
	 *
	 * @param DateTime
	 *            YYYYMMDD
	 * @param plusDay
	 *            더할 월자
	 * @return 특정날짜에 일자를 더한 값
	 */
	public static String getAddMonth(String dateTime, int monthValue) {
		if (dateTime == null) return "";

		int y;
		int m;
		int d;
		y = Integer.parseInt(dateTime.substring(0, 4));
		m = Integer.parseInt(dateTime.substring(4, 6));
		if (dateTime.length() >= 8) {
			d = Integer.parseInt(dateTime.substring(6, 8));
		} else {
			d = 1;
		}


		java.util.GregorianCalendar sToday = new java.util.GregorianCalendar();
		sToday.set(y, m - 1, d);
		sToday.add(GregorianCalendar.MONTH, monthValue);

		int day = sToday.get(GregorianCalendar.DAY_OF_MONTH);
		int month = sToday.get(GregorianCalendar.MONTH) + 1;
		int year = sToday.get(GregorianCalendar.YEAR);

		String sNowyear = String.valueOf(year);
		String sNowmonth = "";
		String sNowday = "";

		if (month < 10)
			sNowmonth = "0" + String.valueOf(month);
		else
			sNowmonth = String.valueOf(month);

		if (dateTime.length() >= 8) {
			if (day < 10)
				sNowday = "0" + String.valueOf(day);
			else
				sNowday = String.valueOf(day);
		}

		return sNowyear + sNowmonth + sNowday;

	}

	/**
	 * 어제 날짜 - YYYYMMDD
	 */
	public static String getYesterday() {
		java.util.GregorianCalendar sToday = new java.util.GregorianCalendar();
		sToday.add(GregorianCalendar.DAY_OF_MONTH, -1);

		int day = sToday.get(GregorianCalendar.DAY_OF_MONTH);
		int month = sToday.get(GregorianCalendar.MONTH) + 1;
		int year = sToday.get(GregorianCalendar.YEAR);

		String sNowyear = String.valueOf(year);
		String sNowmonth = "";
		String sNowday = "";

		if (month < 10)
			sNowmonth = "0" + String.valueOf(month);
		else
			sNowmonth = String.valueOf(month);

		if (day < 10)
			sNowday = "0" + String.valueOf(day);
		else
			sNowday = String.valueOf(day);

		return sNowyear + sNowmonth + sNowday;
	}

	/**
	 * 내일 날짜 - YYYYMMDD
	 */
	public static String getTomorrow() {
		java.util.GregorianCalendar sToday = new java.util.GregorianCalendar();
		sToday.add(GregorianCalendar.DAY_OF_MONTH, 1);

		int day = sToday.get(GregorianCalendar.DAY_OF_MONTH);
		int month = sToday.get(GregorianCalendar.MONTH) + 1;
		int year = sToday.get(GregorianCalendar.YEAR);

		String sNowyear = String.valueOf(year);
		String sNowmonth = "";
		String sNowday = "";

		if (month < 10)
			sNowmonth = "0" + String.valueOf(month);
		else
			sNowmonth = String.valueOf(month);

		if (day < 10)
			sNowday = "0" + String.valueOf(day);
		else
			sNowday = String.valueOf(day);

		return sNowyear + sNowmonth + sNowday;
	}

	/**
	 * 년도 1900 - 9999, 월 01 - 12, 일 01 - 31, 시 00 - 23, 분 00 - 59, 초 00 - 59
	 *
	 * @param param
	 *            검사 문자열
	 *
	 * @return 검사결과
	 */
	public static boolean isDate(String param) {
		if (param == null || param.length() != 8)
			return false;

		try {
			int year = Integer.parseInt(param.substring(0, 4));
			int month = Integer.parseInt(param.substring(4, 6));
			int day = Integer.parseInt(param.substring(6, 8));

			if (year < 1900 || year > 9999)
				return false;
			if (month < 1 || month > 12)
				return false;
			if (day < 1 || day > 31)
				return false;

			return true;
		} catch (NullPointerException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 년도 1900 - 9999, 월 01 - 12, 일 01 - 31, 시 00 - 23, 분 00 - 59, 초 00 - 59
	 *
	 * @param param
	 *            검사 문자열
	 *
	 * @return 검사결과
	 */
	public static boolean isTime(String param) {
		if (param == null || param.length() != 6)
			return false;

		try {
			int hour = Integer.parseInt(param.substring(0, 2));
			int min = Integer.parseInt(param.substring(2, 4));
			int sec = Integer.parseInt(param.substring(4, 6));

			if (hour < 0 || hour > 23)
				return false;
			if (min < 0 || min > 59)
				return false;
			if (sec < 0 || sec > 59)
				return false;

			return true;
		} catch (NullPointerException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 현재년월에서 다음 한달후 년월을 불러온다.
	 *
	 * @param month
	 *            YYYY-MM 타입으로 년월
	 * @return 년월을 String으로 리턴한다.
	 */
	public static String getNextMonth(String month) {
		String lsYear = null;
		String lsMonth = null;

		int liYear = Integer.parseInt(month.substring(0, 4));
		int liMonth = Integer.parseInt(month.substring(5, 7));

		if (liMonth == 12) {
			liMonth = 1;
			liYear++;
		} else
			liMonth++;

		lsYear = liYear + "";

		if (liMonth < 10)
			lsMonth = "0" + liMonth;
		else
			lsMonth = "" + liMonth;

		return lsYear + "-" + lsMonth;
	}// end of getNextMonth

	/**
	 * 현재년월에서 이전 한달전 년월을 불러온다.
	 *
	 * @param Month
	 *            YYYYMM 타입으로 년월
	 * @return 년월을 String으로 리턴한다.
	 */
	public static String getPrevMonth(String Month) {
		String lsYear = null;
		String lsMonth = null;

		int liYear = Integer.parseInt(Month.substring(0, 4));
		int liMonth = Integer.parseInt(Month.substring(4, 6));

		if (liMonth == 1) {
			liMonth = 12;
			liYear--;
		} else
			liMonth--;

		lsYear = liYear + "";

		if (liMonth < 10)
			lsMonth = "0" + liMonth;
		else
			lsMonth = liMonth + "";

		return lsYear + "-" + lsMonth;

	}// end of getPrevMonth

	/**
	 * @param date
	 *            YYYY-MM-DD 포멧이나 YYYY-DD 포멧의 날짜
	 * @return 해당 달의 마지막 날
	 */
	public static String getLastDay(String date) {
		return getLastDay(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)), false);
	}

	/**
	 * @param yyyy
	 *            년
	 * @param mm
	 *            월
	 * @return 해당 달의 마지막 날
	 */
	public static String getLastDay(String yyyy, String mm) {
		return getLastDay(Integer.parseInt(yyyy), Integer.parseInt(mm), false);
	}

	/**
	 * @param yyyy
	 *            년
	 * @param mm
	 *            월
	 * @param isNowDate
	 *            - 구하려는 달이 현재달일 경우 현재 날짜를 리턴할지
	 * @return 해당 달의 마지막 날
	 */
	public static String getLastDay(String yyyy, String mm, boolean isNowDate) {
		return getLastDay(Integer.parseInt(yyyy), Integer.parseInt(mm), isNowDate);
	}

	/**
	 * @param yyyy
	 *            년
	 * @param mm
	 *            월
	 * @param isNowDate
	 *            - 구하려는 달이 현재달일 경우 현재 날짜를 리턴할지
	 * @return 해당 달의 마지막 날
	 */
	public static String getLastDay(int yyyy, int mm, boolean isNowDate) {
		Calendar calendar = Calendar.getInstance();
		String str = "";
		if (isNowDate && mm == calendar.get(Calendar.MONTH) + 1) {
			str = calendar.get(Calendar.DATE) + "";
		} else {
			calendar.set(yyyy, mm - 1, 1);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DATE, -1);
			int date = calendar.get(Calendar.DATE);
			str = date < 10 ? "0" + date : date + "";
		}
		return str;
	}
	
	public static String getCLOB(Clob clob) throws Exception
	{
    	if (clob == null) {
            return "";
        } 
        
    	StringBuffer strOut = new StringBuffer();
        String str = "";
        BufferedReader br = new BufferedReader(clob.getCharacterStream());
        while ((str = br.readLine()) != null) {
            strOut.append(str);
        }
        return strOut.toString();
	}


	public static String getCLOBnBR(Clob clob) throws Exception
	{
		if (clob == null) {
			return "";
		}

		StringBuffer strOut = new StringBuffer();
		String str = "";
		BufferedReader br = new BufferedReader(clob.getCharacterStream());
		while ((str = br.readLine()) != null) {
			strOut.append(str);
			strOut.append(System.lineSeparator());
		}
		return strOut.toString();
	}

	
	/*
	 * image -> Byte
	 */
	public static byte[] imgToByte(File imgFile) throws Exception {
		
		byte[] rs = null;
		
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		
		try {
			
			fis = new FileInputStream(imgFile);
//			bis = new BufferedInputStream(new FileInputStream(imgPath));
			bos = new ByteArrayOutputStream();
			
			byte[] buf = new byte[1024];
			int read = 0;
			
			while ((read=fis.read(buf,0,buf.length)) != -1)
			{
				bos.write(buf, 0, read);
			}
			
			rs = bos.toByteArray();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try{
    			if(bos != null) bos.close();
    		}catch(IOException ioe){
    			ioe.printStackTrace();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		try{
//    			if(bis != null) bis.close();
    			if(fis != null) fis.close();
    		}catch(IOException ioe){
    			ioe.printStackTrace();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
		}
		return rs;
	}
	
	/*
	 * image Type Check 
	 */
	public static boolean checkImageType(MultipartFile imageFile) {
		try {
			// 파일확장자 체크
			String contentType = imageFile.getContentType();
			if (contentType.startsWith("image")) {
				// 실제 파일 확장자 체크
				try (InputStream is = imageFile.getInputStream()){
					Tika tika = new Tika();
					String mimeType = tika.detect(is);
					System.out.print("mimeType = " + mimeType);
					if (mimeType == null || mimeType.equals("")) {
						return false;
					} else {
						if (mimeType.startsWith("image")) {
							return true;
						}
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * Excel Util
	 */
	public static boolean isCellDateFormatted(Cell cell) {
		if (cell == null) return false;
		boolean bDate = false;
		
		double d = cell.getNumericCellValue();
		if ( DateUtil.isValidExcelDate(d) ) {
			CellStyle style = cell.getCellStyle();
			if (style==null) return false;				
			int i = style.getDataFormat();
			String f = style.getDataFormatString();
			bDate = isADateFormat(i, f);
		}
		return bDate;
	}
	
	public static boolean isADateFormat(int formatIndex, String formatString) {
		
		Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]"); 
		Pattern date_ptrn2 = Pattern.compile("^\\[a-zA-Z]+\\");
		Pattern date_ptrn3 = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-/,. :\"\\\\]+0*[ampAMP/]*$");
		Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
		
		// TODO Auto-generated method stub
		if (isInternalDateFormat(formatIndex)) return true; 
		if (formatString == null || formatString.length() == 0) return false;
		
		String fs = formatString;
		
		StringBuilder sb = new StringBuilder(fs.length());
		for (int i = 0; i < fs.length(); i++) {
			char c = fs.charAt(i);
			if(i < fs.length() - 1) {
				char nc = fs.charAt(i + 1);
				if (c == '\\') {
					switch (nc) {
					case '-':
					case ',':
					case '.':
					case ' ':
					case '\\':
						continue;
					}
				} else if (c == ';' && nc == '@') {
					i++;
					continue;
				}
			}
			sb.append(c);
		}
		fs = sb.toString();
		
		if (date_ptrn4.matcher(fs).matches()) return true;
		
		fs = date_ptrn1.matcher(fs).replaceAll("");
		fs = date_ptrn2.matcher(fs).replaceAll("");
		
		if (fs.indexOf(';') > 0 && fs.indexOf(';') < fs.length()-1) {
			fs = fs.substring(0, fs.indexOf(';'));
		}
		
		return date_ptrn3.matcher(fs).matches();
	}
	
	public static boolean isInternalDateFormat(int format) {
		switch (format) {
			case 0x0e:
			case 0x0f:
			case 0x10:
			case 0x11:
			case 0x12:
			case 0x13:
			case 0x14:
			case 0x15:
			case 0x16:
			case 0x2d:
			case 0x2e:
			case 0x2f:
				return true;
		}
		return false;
	}
	
	
	public static boolean isValidExcelDate(double value) {
		// TODO Auto-generated method stub
		return (value > -Double.MIN_VALUE);
	}
	
	public static void setResponseDownload(HttpServletResponse response,String downNm,String savePath) {
    	
    	Cookie fileDwnld=new Cookie("fileDownload","true");
		fileDwnld.setPath("/");
		response.addCookie(fileDwnld);
		
		response.setContentType("application/octer-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Disposition", "attachment; fileName=\"" +downNm+ "\"");
        response.setCharacterEncoding("utf-8");
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis2 = new FileInputStream(savePath);

            int ncount = 0;
            byte[] bytes = new byte[512];

            while ((ncount = fis2.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis2.close();
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

}