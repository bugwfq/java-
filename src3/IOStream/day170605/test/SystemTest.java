package IOStream.day170605.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
/**
 * �ض���
 * @author Administrator
 *
 */
public class SystemTest {
	//@Test
	public void test1()throws Exception{
		System.out.println("hello world");//���������̨
		//ͨ���ض��򷽷�setOut�������·��������̨���ض��򵽣��ļ���
		System.setOut(new PrintStream(new FileOutputStream(new File("src3/day170605/test/a.txt"))));
		System.out.print("hello cc\n");//������ļ�
		System.out.println("hello dd");
		
	}
	
	@Test
	public void test2()throws Exception{
		//ͨ���ض��򷽷�SetIn������·����(����)�ض���(�ļ�)
		System.setIn(new FileInputStream(new File("src3/day170605/test/a.txt")));
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		while(sc.hasNext()){
//			String str = sc.nextLine();
			String str = sc.next();
			System.out.println(str);
		}
	}
}
