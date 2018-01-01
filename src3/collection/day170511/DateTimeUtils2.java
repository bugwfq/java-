package collection.day170511;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils2 {
	/**
	 * String->Date
	 */
	public Date strToDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Date->String
	 */
	public String DateToStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(date);
	}
	
	/**
	 * long->Date
	 */
	public Date longToDate(Long l){
		Date date = new Date(l);
		return date;
	}
	
	public Date longToDate2(Long l){
		Date date = new Date();
		date.setTime(l);
		return date;
	}
	
	/**
	 * Date->long
	 */
	public Long DateToLong(Date date){
		return date.getTime();
	}
	
	/**
	 * Calendar->Date
	 */
	public Date CalendarToDate(Calendar c){
		return c.getTime();
	}
	
	/**
	 * Date->Calendar 
	 */
	public Calendar DateToCalendar(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
	
	
	public static int getYear(Calendar c){
		return c.get(Calendar.YEAR);
	}
	
	public static int getMonth(Calendar c){
		return c.get(Calendar.MONTH)+1;
	}
	
	public static long calendarToLong(Calendar c){
		return c.getTimeInMillis();
	}
	
	public static Calendar longToCalendar(long l){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(l);
		return c;
	}
	
	public static String longDateToShortDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(date);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		String str = sdf1.format(newDate);
		return str;
	}
	
	public static String shortDateToLongDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date newDate = sdf.parse(date);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		return sdf1.format(newDate);
	}
	
}
