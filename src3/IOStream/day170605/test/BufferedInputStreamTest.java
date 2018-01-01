package IOStream.day170605.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

public class BufferedInputStreamTest {
	@Test
	public void test1() throws Exception{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("src3/day170605/test/BufferedInputStreamTest.java")),4);
		System.out.println(bis.markSupported());
		bis.mark(3);
		
		System.out.println((char)bis.read());
		System.out.println((char)bis.read());
		System.out.println((char)bis.read());

		
		bis.reset();
		System.out.println((char)bis.read());
		System.out.println((char)bis.read());
		System.out.println((char)bis.read());

	}
}
