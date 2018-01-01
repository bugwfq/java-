package collection.day170511;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
	public static Date longToDate(long l){
		Date date = new Date(l);
		return date;
	}
	
	public static Date longToDate2(long l){
		Date date = new Date();
		date.setTime(l);
		return date;
	}
	
	public static long dateToLong(Date date){
		return date.getTime();
	}
	
	public static Date calendarToDate(Calendar c){	
		return c.getTime();	
	}
	
	public static Calendar dateToCalendar(Date date){
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
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyMMdd");
		return sdf2.format(newDate);
	}
	
	public static String shortDateToLongDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date newDate = sdf.parse(date);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		return sdf2.format(newDate);		 
	}
	
	public static String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static Date StringToDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(date);
	}
	
	
	
	
	
}
