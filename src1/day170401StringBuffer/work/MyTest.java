package day170401StringBuffer.work;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		MyStringBuffer ms = new MyStringBuffer("hello world");
		System.out.println(ms.append(false));//将 boolean 参数的字符串表示形式追加到序列 
		System.out.println(ms.append('H'));//将 char 参数的字符串表示形式追加到此序列 
		System.out.println(ms.capacity());//返回当前容量
		System.out.println(ms.delete(2, 6));//移除此序列的子字符串中的字符
		char[] c = {'F','A','D'};
		System.out.println(ms.insert(2,c ));//将 char 数组参数的字符串表示形式插入此序列中
		System.out.println(ms.reverse());// 将此字符序列用其反转形式取代
		
		
		
	}
	
}
