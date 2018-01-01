package IOStream.day170602.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class ByteArrayOutputStreamTest {
	@Test
	public void test(){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(97);
		bos.write(98);
		bos.write(99);
		bos.write(100);
		
		/*byte[] bs = bos.toByteArray();
		for (byte b : bs) {
			System.out.println((char)b);
		}
		try {
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		File file = new File("src3/day170602/test/a.txt");
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(file);
			
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}
		
		try {
			bos.writeTo(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
