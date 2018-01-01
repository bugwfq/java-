package day170329String类.test;

import org.junit.Test;

public class Test1 {
	//@Test
	public void test1(){
		char c1 = 'a';
		Character c11 = c1;//自动装箱
		char c2 = 'a';
		Character c22 = new Character(c2);//构造器 
		char c3 = 'a';
		Character c33 = Character.valueOf(c3);//valueOf方法
	}
	
	//@Test
	public void test2(){
		char[] c1 = {'a','b','c','d'};
		System.out.println(Character.codePointAt(c1, 1));//数组给定索引上的代码点
		System.out.println((char)98);
		
		System.out.println();
		
		System.out.println(Character.isJavaIdentifierPart(2));
		System.out.println((char)99);//数字转字母
		System.out.println((int)'a');//字母转数字
		
	}
	@Test
	public void test3(){
		char[] c = {'a','b','c','d','e','f','g'};
		String str = new String(c);
		System.out.println(str);
		
		byte[] bs = {'a','b','c','d','e','f','g'};
		String sc = new String(bs,3,4);
		System.out.println(sc);
		
		String s = new String("abc");
		
		
	}
}
