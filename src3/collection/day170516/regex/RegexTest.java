package collection.day170516.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {
	//@Test
	public void test(){
		System.out.println(regex("4"));
		System.out.println(regex1("e"));
	}
	public static boolean regex(String manager){
		Pattern pattern = Pattern.compile("\\d");//0-9任何一个数字
		Matcher m = pattern.matcher(manager);
		return m.matches();
	}
	
	public static boolean regex1(String manager){
		Pattern pattern = Pattern.compile("[^abc]");//0-9任何一个数字
		Matcher m = pattern.matcher(manager);
		return m.matches();
	}
	
	//@Test
	public void test1(){
		boolean bool = Pattern.matches("\\d{3}", "254");
		System.out.println(bool);
	}
	//@Test
	public void test2(){
		//先编译一个正则表达式
		Pattern p = Pattern.compile("\\d{3}");
		Matcher m = p.matcher("125");
		boolean bool = m.matches();
		System.out.println(bool);
	}
	@Test
	public void test3(){
		String str = "123";
		String regex = "\\d{3}";
		boolean bool = Pattern.matches(regex, str);
	}
	
	
}
