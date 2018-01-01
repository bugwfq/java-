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
		cw.write('��');
		cw.write('С');
		
		/*char[] cs = cw.toCharArray();//�������������ݻ�ȡ��������
		for (char c : cs) {
			System.out.print(c);
		}*/
		cw.reset();//���ã���ջ��������ݣ�
		cw.append('��');
		cw.append('c');
		cw.append('e');
		
		String s = cw.toString();
		System.out.println(s);
		
	}
}
