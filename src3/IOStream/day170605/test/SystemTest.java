package IOStream.day170605.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
/**
 * 重定向
 * @author Administrator
 *
 */
public class SystemTest {
	//@Test
	public void test1()throws Exception{
		System.out.println("hello world");//输出到控制台
		//通过重定向方法setOut，将输出路径（控制台）重定向到（文件）
		System.setOut(new PrintStream(new FileOutputStream(new File("src3/day170605/test/a.txt"))));
		System.out.print("hello cc\n");//输出到文件
		System.out.println("hello dd");
		
	}
	
	@Test
	public void test2()throws Exception{
		//通过重定向方法SetIn将输入路径由(键盘)重定向到(文件)
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
