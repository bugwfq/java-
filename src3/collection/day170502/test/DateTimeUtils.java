package collection.day170502.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
	/**
	 * 日期时间工具类
	 */
public class DateTimeUtils {
		
	/**
	 * 四种日期格式之间的转换
	 */
	
	/**
	 * Date -> long
	 */
	public static long DateToLong(Date date){
		long l = date.getTime();
		return l;
	}
	
	/**
	 * long -> Date
	 */
	
	public static Date longToDate(long l){
		Date date = new Date(l);
		return date;
	}
	
	public static Date longToDate2(long l){
		Date date = new Date();
		date.setTime(l);
		return date;
	}
	/**
	 * Date -> Calendar
	 */
	public static Calendar DateToCalendar(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
	
	/**
	 * Calendar -> Date
	 */
	public static Date CalendarToDate(Calendar c){
		return c.getTime();	
	}
	
	/**
	 * Date -> String
	 */
	public static String DateToString(Date date){
		String s = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(s);
		sdf.format(date);
		return s;
	}
	
	public static String DateToString(Date date,String pattern){
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);	
		String s = sdf.format(date);
		return s;
	}
	
	/**
	 * String -> Date
	 */
	public static Date StringToDate(String date,String pattern){
		Date newDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			newDate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDate;
	}
	
	
}
