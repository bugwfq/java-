package day170331String�����.test;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		String s = "123,8000,32332,true";
		String[] ss = s.split(",");
		System.out.println(ss.length);
		for(String temp:ss){
			System.out.println(temp);
		}
		System.out.println("�˺ţ�"+ss[0]);
		System.out.println("��"+ss[1]);
		
		String s1 = "123,8000,32332,true;124,9000,32332,true";
		String[] ss1 = s1.split(";");
		System.out.println(ss1.length);
		for(String temp:ss1){
			String[] ss2 = temp.split(",");
		}
		System.out.println("������"+ss1[0]);
		System.out.println("���ģ�"+ss1[1]);
	}
	//@Test
	public void test2(){
		String s1 = "hkllo hkllo";
		System.out.println(s1.replace('k', 'e'));
		
		System.out.println(s1.replace("hkllo", "hello"));
	}
	//@Test
	public void test3(){
		String s1 = "hello world";
		System.out.println(s1.substring(6));//world
		System.out.println(s1.substring(1,5));//ello
		System.out.println(s1.subSequence(0, 3));//hel
	}
	@Test
	public void test4(){
		/**
		 *  String intern() �����ַ�������Ĺ淶����ʾ��ʽ 
		 */
		String s = "abcdef   ..";
		System.out.println(s.intern());
		
		/**
		 *  int offsetByCodePoints(int index, int codePointOffset) 
          ���ش� String �дӸ����� index ��ƫ�� codePointOffset �������������� 
		 */
		String s1 = "dhfihetejgi";
		System.out.println(s1.offsetByCodePoints(2, 6));//8
		
		/**
		 *  CharSequence subSequence(int beginIndex, int endIndex) 
          ����һ���µ��ַ����У����Ǵ����е�һ�������� 
		 */
		String s2 = "hello world";
		System.out.println(s2.subSequence(4, 9));//o wor
		
		/**
		 *  String substring(int beginIndex) 
		 *  ����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ���
		 */
		System.out.println(s2.substring(2));//llo world
		
		/**
		 * static String valueOf(char[] data, int offset, int count) 
          	���� char ����������ض���������ַ�����ʾ��ʽ 
		 */
		char[] data = {'h','e','l','l','o'};
		System.out.println(String.valueOf(data, 0, 5));
	}
}
