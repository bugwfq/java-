package collection.day170516.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest3 {
	//@Test
	public void test1(){
		String str = "service@xsoftlab.net";
		
		String regex = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		Pattern p = Pattern .compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		boolean bool = m.matches();
		System.out.println(bool);
		
		
	}
	
	@Test
	public void test2(){
		
		String str = "baike.xsoftlab.net";
		
		String regex = "baike.*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean  bool = m.matches();
		System.out.println(bool);
	}
}
