package text;

import java.util.Scanner;

import org.omg.CORBA.portable.ValueOutputStream;

public class SysMyString {
	private static Scanner sc = new Scanner(System.in);
	@org.junit.Test
	public void Test (){
		System.out.println("«Î ‰»Î“ª¥Æ◊÷∑˚");
		String s = sc.next();
		char[] p = s.toCharArray();
		String s1 = "";
		System.out.println(s1.copyValueOf(p));
	}
	
	
}
