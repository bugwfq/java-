package IOStream.day170605.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FileStreamTest {
	//@Test
	public void test1(){
		//文件介质
		File file = new File("src3/day170605/test/FileStreamTest.java");
		//将文件与程序连接(将文件中的内容读入到程序)
		FileInputStream fs = null;//字节流
		try {
			fs = new FileInputStream(file);
			int mark = 0;
			try {
				while((mark=fs.read())!=-1){
					System.out.print((char)mark);
				}
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	@Test
	public void test2() {
		//字符流
		try {
			FileReader fr = new FileReader(new File("src3/day170605/test/FileStreamTest.java"));
			int mark = 0;
			try {
				while((mark=fr.read())!=-1){
					System.out.print((char)mark);
				}
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}
		
	}
}
