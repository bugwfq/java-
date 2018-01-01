package IOStream.day170606.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PrintStreamTest {
	//@Test
	public void test1()throws Exception{
		/**
		 * 字节打印流(会自动调用flush)
		 */
		PrintStream ps = new PrintStream(new FileOutputStream(new File("src3/day170606/test/a.txt")));
//		ps.print("hello world");//自动调用flush
//		ps.println("hello world...");//自动调用flush
		ps.print("hello cc\n");//自动调用flush
		ps.close();
	}
	
	@Test
	public void test2()throws Exception{//默认调用flush
		PrintStream ps = new PrintStream(new FileOutputStream(new File("src3/day170606/test/a.txt")),false);
//		ps.print("hello world...");
//		ps.println("hello world");
		ps.print("hello cc\n");
		ps.close();
	}
}
