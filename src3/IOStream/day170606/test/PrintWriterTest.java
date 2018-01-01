package IOStream.day170606.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.junit.Test;

public class PrintWriterTest {
	//@Test
	public void test1()throws Exception{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src3/day170606/test/a.txt")));
//		pw.println("hello ");//�����Զ�����flush
		pw.print("hello ccc\n");//�����Զ�����flush
		pw.close();//�ر���ʱ�����һ��flush
	}
	
	@Test
	public void test2()throws Exception{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src3/day170606/test/a.txt")),true);//����trueʱ�������flush
//		pw.println("hello ...");
//		pw.print("hello world.\n");//����trueʱ��Ҳ�������flush
//		pw.printf("hello ...");//�����flush
//		pw.format("%s,%s", "hello","world...");
		pw.printf("hello %s, %s","world","haha...");
		
	}
}
