package collection.day170515.test2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class MyScanner {
	//@Test
	public void test(){
		Scanner sc = new Scanner(System.in);//ɨ�����
		//ָ��������Ϊɨ�����
		
		sc.useDelimiter("\n");
	
		String str = sc.next();//�Կո���Ϊɨ�����
		System.out.println(str);
	}
	
	//@Test
	public void test2(){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//Ĭ���û��з���Ϊɨ��Ľ���
		System.out.println(str);
	}
	//@Test
	public void test3(){
		Scanner sc = new Scanner("hello world hello cc");
	/*	String str = sc.next();
		String str1 = sc.next();
		System.out.println(str);
		System.out.println(str1);*/
		
		while(sc.hasNext()){
			String str = sc.next();
			System.out.println(str);
		}
	
	}
	
	@Test
	public void test4() throws FileNotFoundException{
		File file = new File("src3/day170515/test2/test.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()){
			int i = sc.nextInt();
			System.out.println(i);
		}
	}
}
