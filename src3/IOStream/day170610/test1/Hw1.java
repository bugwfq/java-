package IOStream.day170610.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Hw1 {
	/**
	 * 1.ʹ��FileInputStream��FileOutputStream�������ļ������ݺϲ���һ���µ��ļ����µ��ļ��������������ļ�������.
	 * @throws IOException 
	 */
	
	@Test
	public void test() throws IOException{
		
		FileInputStream fis = new FileInputStream(new File("src3/day170610/test1/a.txt"));
		FileOutputStream fos = new FileOutputStream(new File("src3/day170610/test1/c.txt"));
		
		int mark = 0;
		while((mark=fis.read())!=-1){
			fos.write(mark);
		}
		
		fis = new FileInputStream(new File("src3/day170610/test1/b.txt"));
		mark = 0;
		while((mark=fis.read())!=-1){
			fos.write(mark);
		}
			
	}
}
