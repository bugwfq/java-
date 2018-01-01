package IOStream.day170610.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Hw1 {
	/**
	 * 1.使用FileInputStream和FileOutputStream将两个文件的内容合并至一个新的文件，新的文件将包含这两个文件的内容.
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
