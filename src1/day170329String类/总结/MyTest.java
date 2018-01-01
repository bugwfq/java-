package day170329StringÀà.×Ü½á;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		StringTest s = new StringTest("abc:abc:abc:a");
		System.out.println(s.charAt(6));
		System.out.println(s.codePointAt(3));
		System.out.println(s.codePointBefore(3));
		System.out.println(s.codePointCount(2, 6));
		System.out.println(s.compareTo("ajgikjogjer"));
		System.out.println(s.compareToIgnoreCase("abcdefg"));
		System.out.println(s.concat("aaaa"));
		System.out.println(s.contains("dg"));
		char[] c = {'c','d','e'};
		System.out.println(StringTest.copyValueOf(c));
		char[] cc ={'d','j','f','k','d','g','e'};
		System.out.println(String.copyValueOf(cc, 2, 5));
	
//		char[] ccc = new char[10];
//		s.getChars(0, 3, ccc, 2);
//		for(char i:ccc){
//			System.out.print(i);
//		}
		
		System.out.println("--------------");
		StringTest st = new StringTest("aa;bb;ccc;d");
		for(String i:st.split(";")){
			if(i!=null){
				System.out.println(i);
			}
			System.out.println(i);
		}
		
		
//		String ss = s.replaceAll("ca", "A");
//		System.out.println(ss);
//		for(String i:s.split("$")){
//			System.out.println(i);
//		}
//		
	}
}
