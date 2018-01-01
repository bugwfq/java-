package day170329String类.work;
import org.junit.Test;

import day170329String类.总结.StringTest;
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
		//1.int	codePointAt(int index):返回指定索引处的字符（Unicode 代码点）
		String str = "abcdefg";
		int index = str.codePointAt(3);
		System.out.println((char)index);//结果：b
		//2.int	codePointBefore(int index):返回指定索引之前的字符（Unicode 代码点）
		System.out.println((char)str.codePointBefore(3));//结果:c
		//3.int	compareTo(String anotherString):按字典顺序比较两个字符串
		String s = "abc";
		System.out.println(str.compareTo(s));
		//4.int	compareToIgnoreCase(String str):按字典顺序比较两个字符串，不考虑大小写
		String s1 = "AgXjd";
		System.out.println(str.compareToIgnoreCase(s1));
		//5.String	concat(String str):将指定字符串连接到此字符串的结尾
		System.out.println(str.concat(s1));//结果：abcdefgAgXjd
		//6.static String	copyValueOf(char[] data):返回指定数组中表示该字符序列的 String
		char[] data = {'H','a','p','p','y','N','e','w','Y','e','a','r'};
		String s2 ="";
		System.out.println(s2.copyValueOf(data));//HappyNewYear
		/*7.static String	copyValueOf(char[] data, int offset, int count):
		返回指定数组中表示该字符序列的 String*/
		System.out.println(s2.copyValueOf(data, 5, 3));
		//8.boolean	endsWith(String suffix): 测试此字符串是否以指定的后缀结束
		String s3 = "MerryChristmas";
		System.out.println(s3.endsWith("mas"));//true
		//9.int	indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引
		String s4 = "abcdefgfedcba";
		System.out.println(s4.indexOf(100));//3->d
		//10.int	indexOf(int ch, int fromIndex):返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
		System.out.println(s4.indexOf(99, 3));//10->c
		//11.int	indexOf(String str):返回指定子字符串在此字符串中第一次出现处的索引
		String s5 = "adloglcealdi";
		String s55 = "l";
		System.out.println(s5.indexOf(s55));
		//12.int	indexOf(String str, int fromIndex):返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
		System.out.println(s5.indexOf(s55, 3));//5->l
		StringTest st = new StringTest("abc,,ckdj,,kd,,hdk");
		System.out.println(st.split(",,"));
	}
}
