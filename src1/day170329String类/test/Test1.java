package day170329String��.test;

import org.junit.Test;

public class Test1 {
	//@Test
	public void test1(){
		char c1 = 'a';
		Character c11 = c1;//�Զ�װ��
		char c2 = 'a';
		Character c22 = new Character(c2);//������ 
		char c3 = 'a';
		Character c33 = Character.valueOf(c3);//valueOf����
	}
	
	//@Test
	public void test2(){
		char[] c1 = {'a','b','c','d'};
		System.out.println(Character.codePointAt(c1, 1));//������������ϵĴ����
		System.out.println((char)98);
		
		System.out.println();
		
		System.out.println(Character.isJavaIdentifierPart(2));
		System.out.println((char)99);//����ת��ĸ
		System.out.println((int)'a');//��ĸת����
		
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
