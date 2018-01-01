package IOStream.day170602.test;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

public class CharArrayWriterTest {
	@Test
	public void test() throws Exception{
		CharArrayWriter cw = new CharArrayWriter();
		cw.write('a');
		cw.write('b');
		cw.write('大');
		cw.write('小');
		
		/*char[] cs = cw.toCharArray();//将缓冲区的内容获取到数组中
		for (char c : cs) {
			System.out.print(c);
		}*/
		cw.reset();//重置（清空缓冲区内容）
		cw.append('中');
		cw.append('c');
		cw.append('e');
		
		String s = cw.toString();
		System.out.println(s);
		
	}
}
