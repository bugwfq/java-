package collection.day170515.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ScannerTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		String str = sc.next();//以空格作为结束
		System.out.println(str);
	}
	
	//@Test
	public void test2(){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//默认以换行符为扫描的结束
		System.out.println(str);
	}
	
	//@Test
	public void test3(){
		Scanner sc = new Scanner("hello world hello cc");
		String str = sc.next();
		System.out.println(str);
		String str1 = sc.next();
		System.out.println(str1);
		String str2 = sc.next();
		System.out.println(str2);
		String str3 = sc.next();
		System.out.println(str3);
//		while(sc.hasNext()){
//			String str = sc.next();
//			System.out.println(str);
//		}
	}
	
	@Test
	public void test4() throws FileNotFoundException{
		File file = new File("src3/day170515/test/a.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNext()){
			int i = sc.nextInt();
			System.out.println(i);
		}
	}
}
