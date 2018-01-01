package IOStream.day170606.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.junit.Test;

public class PrintWriterTest {
	//@Test
	public void test1()throws Exception{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src3/day170606/test/a.txt")));
//		pw.println("hello ");//不会自动调用flush
		pw.print("hello ccc\n");//不会自动调用flush
		pw.close();//关闭流时会调用一次flush
	}
	
	@Test
	public void test2()throws Exception{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src3/day170606/test/a.txt")),true);//当是true时，会调用flush
//		pw.println("hello ...");
//		pw.print("hello world.\n");//当是true时，也不会调用flush
//		pw.printf("hello ...");//会调用flush
//		pw.format("%s,%s", "hello","world...");
		pw.printf("hello %s, %s","world","haha...");
		
	}
}
