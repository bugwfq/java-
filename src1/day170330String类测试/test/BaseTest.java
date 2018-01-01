package day170330StringÀà²âÊÔ.test;
import org.junit.Test;
public class BaseTest {
	@Test
	public void test1(){
		/**
		 *  char charAt(int index) 
		 *  int codePointAt(int index) 	
		 * 	int codePointBefore(int index) 
		 */
		String s = "abcd";
		System.out.println(s.charAt(1));//b
		System.out.println(s.codePointAt(1));//98
		System.out.println(s.codePointBefore(1));//97
	}
	@Test
	public void test2(){
		/**
		 * int compareTo(String anotherString) 
		 * int compareToIgnoreCase(String str) 
		 * boolean equals(Object anObject)   
		 * boolean equalsIgnoreCase(String anotherString)  
		 */
		String s1 = "abc";
		String s2 = "Abc";
		System.out.println(s1.compareTo(s2));//32
		System.out.println(s1.compareToIgnoreCase(s2));//0
		System.out.println(s1.equals(s2));//false
		System.out.println(s1.equalsIgnoreCase(s2));//true
	}
	@Test
	public void test3(){
		/**
		 * String concat(String str) 
		 * boolean contains(CharSequence s) 
		 * boolean isEmpty()   
		 */
		String s1 = "hello world";
		String s2 = "world";
		System.out.println(s1.concat(s2));//hello worldworld
		System.out.println(s1.contains(s2));//true
		String s3 ="";//null->Å×Òì³££»"null"->false;" "->false
		System.out.println(s3.isEmpty());
	}
	@Test
	public void test4(){
		String s = "abcdefghi";
		char[] c = new char[s.length()];
		s.getChars(1, 4, c, 3);
		for(char i:c){
			System.out.println(i);
		}
	}
}
