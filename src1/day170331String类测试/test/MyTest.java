package day170331String类测试.test;

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
		System.out.println("账号："+ss[0]);
		System.out.println("金额："+ss[1]);
		
		String s1 = "123,8000,32332,true;124,9000,32332,true";
		String[] ss1 = s1.split(";");
		System.out.println(ss1.length);
		for(String temp:ss1){
			String[] ss2 = temp.split(",");
		}
		System.out.println("张三："+ss1[0]);
		System.out.println("李四："+ss1[1]);
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
		 *  String intern() 返回字符串对象的规范化表示形式 
		 */
		String s = "abcdef   ..";
		System.out.println(s.intern());
		
		/**
		 *  int offsetByCodePoints(int index, int codePointOffset) 
          返回此 String 中从给定的 index 处偏移 codePointOffset 个代码点的索引。 
		 */
		String s1 = "dhfihetejgi";
		System.out.println(s1.offsetByCodePoints(2, 6));//8
		
		/**
		 *  CharSequence subSequence(int beginIndex, int endIndex) 
          返回一个新的字符序列，它是此序列的一个子序列 
		 */
		String s2 = "hello world";
		System.out.println(s2.subSequence(4, 9));//o wor
		
		/**
		 *  String substring(int beginIndex) 
		 *  返回一个新的字符串，它是此字符串的一个子字符串
		 */
		System.out.println(s2.substring(2));//llo world
		
		/**
		 * static String valueOf(char[] data, int offset, int count) 
          	返回 char 数组参数的特定子数组的字符串表示形式 
		 */
		char[] data = {'h','e','l','l','o'};
		System.out.println(String.valueOf(data, 0, 5));
	}
}
