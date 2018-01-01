package IOStream.day170602.test;

import java.io.CharArrayReader;
import java.io.IOException;

import org.junit.Test;

public class CharArrayReaderTest {
	@Test
	public void test() throws IOException{
		char[] cs = {'a','b','c','÷–','¥Û','”“'};
		CharArrayReader cr = new CharArrayReader(cs);
		int mark = 0;
		while((mark=cr.read())!=-1){
			System.out.print((char)mark);
		}
	}
	
	
}
