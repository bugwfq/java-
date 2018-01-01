package collection.day170502.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class SimpleDateFormatTest {
	@Test
	public void test1(){
		Date date = new Date();
		
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(date);
		System.out.println(s);
	}
}
