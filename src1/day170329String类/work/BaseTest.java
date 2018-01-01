package day170329String��.work;
import org.junit.Test;

import day170329String��.�ܽ�.StringTest;
public class BaseTest {
	/**
	 * 
	 * 1.int	codePointAt(int index) 
	 * 2.int	codePointBefore(int index) 
	 * 3.int	compareTo(String anotherString) 
	 * 4.int	compareToIgnoreCase(String str) 
	 * 5.String	concat(String str) 
	 * 6.static String	copyValueOf(char[] data) 
	 * 7.static String	copyValueOf(char[] data, int offset, int count) 
	 * 8.boolean	endsWith(String suffix) 
	 * 9.int	indexOf(int ch) 
	 * 10.int	indexOf(int ch, int fromIndex) 
	 * 11.int	indexOf(String str) 
	 * 12.int	indexOf(String str, int fromIndex) 
	 */
	
	@Test
	public void test1(){
		//1.int	codePointAt(int index):����ָ�����������ַ���Unicode ����㣩
		String str = "abcdefg";
		int index = str.codePointAt(3);
		System.out.println((char)index);//�����b
		//2.int	codePointBefore(int index):����ָ������֮ǰ���ַ���Unicode ����㣩
		System.out.println((char)str.codePointBefore(3));//���:c
		//3.int	compareTo(String anotherString):���ֵ�˳��Ƚ������ַ���
		String s = "abc";
		System.out.println(str.compareTo(s));
		//4.int	compareToIgnoreCase(String str):���ֵ�˳��Ƚ������ַ����������Ǵ�Сд
		String s1 = "AgXjd";
		System.out.println(str.compareToIgnoreCase(s1));
		//5.String	concat(String str):��ָ���ַ������ӵ����ַ����Ľ�β
		System.out.println(str.concat(s1));//�����abcdefgAgXjd
		//6.static String	copyValueOf(char[] data):����ָ�������б�ʾ���ַ����е� String
		char[] data = {'H','a','p','p','y','N','e','w','Y','e','a','r'};
		String s2 ="";
		System.out.println(s2.copyValueOf(data));//HappyNewYear
		/*7.static String	copyValueOf(char[] data, int offset, int count):
		����ָ�������б�ʾ���ַ����е� String*/
		System.out.println(s2.copyValueOf(data, 5, 3));
		//8.boolean	endsWith(String suffix): ���Դ��ַ����Ƿ���ָ���ĺ�׺����
		String s3 = "MerryChristmas";
		System.out.println(s3.endsWith("mas"));//true
		//9.int	indexOf(int ch):����ָ���ַ��ڴ��ַ����е�һ�γ��ִ�������
		String s4 = "abcdefgfedcba";
		System.out.println(s4.indexOf(100));//3->d
		//10.int	indexOf(int ch, int fromIndex):�����ڴ��ַ����е�һ�γ���ָ���ַ�������������ָ����������ʼ����
		System.out.println(s4.indexOf(99, 3));//10->c
		//11.int	indexOf(String str):����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�������
		String s5 = "adloglcealdi";
		String s55 = "l";
		System.out.println(s5.indexOf(s55));
		//12.int	indexOf(String str, int fromIndex):����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�����������ָ����������ʼ
		System.out.println(s5.indexOf(s55, 3));//5->l
		StringTest st = new StringTest("abc,,ckdj,,kd,,hdk");
		System.out.println(st.split(",,"));
	}
}
