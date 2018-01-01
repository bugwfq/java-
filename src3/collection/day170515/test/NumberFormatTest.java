package collection.day170515.test;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

public class NumberFormatTest {
	@Test
	public void test1(){
		//货币格式化
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		String str = nf.format(1000000);
		System.out.println(str);
		
		NumberFormat nf1 = NumberFormat.getCurrencyInstance(Locale.GERMAN);
		String str1 = nf1.format(1000000);
		System.out.println(str1);
	}
	
	@Test
	public void test2(){
		//整数格式化
		NumberFormat nf = NumberFormat.getIntegerInstance(Locale.CHINA);
		String str = nf.format(1000000);
		System.out.println(str);
		
		NumberFormat nf1 = NumberFormat.getIntegerInstance(Locale.GERMAN);
		String str1 = nf1.format(1000000);
		System.out.println(str1);
	}
	
	@Test
	public void test3(){
		NumberFormat nf = NumberFormat.getPercentInstance(Locale.CHINA);
		String str = nf.format(0.15);
		System.out.println(str);
		
		NumberFormat nf1 = NumberFormat.getPercentInstance(Locale.GERMAN);
		String str1 = nf1.format(0.2);
		System.out.println(str1);
	}
}
