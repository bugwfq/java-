package IOStream.day170610.test2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.junit.Test;

public class LineNumberReaderDemo {
	@Test
	public void test() throws IOException{
		LineNumberReader lr = new LineNumberReader(new FileReader("src3/IO流/day170610/test2/LineNumberReaderDemo.java"));
		String line = null;
//		lr.setLineNumber(10);//设置开始的行号
		while((line=lr.readLine())!=null){
			System.out.println(lr.getLineNumber()+":"+line);
		}
		
		lr.close();
	}
	
}
