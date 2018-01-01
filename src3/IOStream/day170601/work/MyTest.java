package IOStream.day170601.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class MyTest {

	//@Test
	public void test1(){
		File file = new File("src3/day170601/test/a.txt");
		FileInputStream fs = null;
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
		}
	}
	//@Test
	public void test2() throws IOException{
		File file = new File("src3/day170601/test/a.txt");
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(file);
			
			byte[] bs = new byte[65536];
			for(int i=0;i<=65535;i++){
				bs[i] = (byte)i;
			}
				
			fs.write(bs);
				
		
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}finally{
			fs.close();
		}
	}
	
	@Test
	public void test3(){
		File rfile = new File("src3/day170601/work/MyTest.java");
		FileInputStream fs = null;
		byte[] bs = null;
		try {
			fs = new FileInputStream(rfile);
			bs = new byte[(int)rfile.length()];
			
			try {
				fs.read(bs);
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
		
		
		File wfile = new File("src3/day170601/work/MyTest.java.bak");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(wfile);
			try {
				fos.write(bs);
				
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
