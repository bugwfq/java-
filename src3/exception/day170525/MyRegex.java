package exception.day170525;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MyRegex {
	//@Test
	public void test1(){
		//匹配5个字母
		String regex = "[a-zA-z]{5}";
		boolean bool = Pattern.matches(regex, "abcjg");
		System.out.println(bool);
	}
	
	//@Test
	public void test2(){
		//匹配6个字母忽略大小写
		String regex = "[a-zA-Z]{6}";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("dGhOir");
		boolean bool = m.matches();
		System.out.println(bool);
	}
	
	//@Test
	public void test3(){
		String regex = ",";
		Pattern p = Pattern.compile(regex);
		String str = "a,b,c,d,e";		
		String[] s = p.split(str);
		for (String string : s) {
			System.out.println(string);
		}
	}
	
	//@Test
	public void test4(){
		String s = "fabckg1274abhjd377abc738abc84";
		String regex = "[a-z]{3,6}";//找到三到六位字母
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		
		while(m.find()){
			String subString = m.group();
			System.out.println(subString);
		}
	
//		m.find();
//		System.out.println(m.start()+"-------"+m.end());
//		m.reset();
//		m.find();
//		System.out.println(m.start()+"-------"+m.end());
	}
	
	//@Test
	public void test5(){
		//用于保存账号信息
		String account = "admin383590dkjik0498jdk984dkjf9345lhgll98853simon3758";
		
		String regex = "([a-zA-Z]{4,6})(\\d{4,6})";//匹配一个账号
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(account);
		while(m.find()){
//			System.out.println(m.group());//admin383590,dkjik0498,dkjf9345,lhgll98853,simon3758
			System.out.println(m.group(1));//admin,dkjik,dkjf,lhgll,simon
		}
	
	}
	
	//@Test
	public void test6(){
		//流量业务：回复ok200 ok500充对应金额的流量
		String s = "hjfdok200jfodff888jkok500jhg909";
		String regex = "ok(\\d{1,3})";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		double pay = 0;
		while(m.find()){
			pay += Double.valueOf(m.group(1));
		}
		System.out.println(pay);
	}
	
	//@Test
	public void test7(){
		String str = "ahb dk JaVa java jaVa JAva JaVA javA jAVa JAVa jAvA dafd";
		String regex = "java";
		Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		while(m.find()){
			count++;//如果找就加一
			if(count%2==0){//偶数变为JAVA
				m.appendReplacement(buffer, "JAVA");
			}else{//奇数变为java
				m.appendReplacement(buffer, "java");
			}			
		}
		m.appendTail(buffer);
		System.out.println(buffer);
	}
	
	@Test
	public void test8(){
		//String里的replace与Regex里的replace对比
		String str = "helle aa helle bb helle cc";
//		String s = str.replaceFirst("helle", "hello");
		String s = str.replaceAll("helle", "hello");
		System.out.println(s);
		
		System.out.println("----------------------------");
		
		String regex = "helle";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
//		String newS = m.replaceFirst("hello");
		String newS = m.replaceAll("hello");
		System.out.println(newS);
		
	}
}
