package IOStream.day170601.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class IOTest {
	//@Test
	public void test1(){
		//字节流
		//文件介质
		File file = new File("src3/day170601/test/IOTest.java");
		FileInputStream fs = null;
		try {
			//搭建文件与程序之间的管道
			fs = new FileInputStream(file);
			int mark = 0;
			try {
				while((mark=fs.read()) != -1){
					System.out.print((char)mark);
				}
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件找不到异常");
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test2(){
		//字符流
		//文件介质
		File file = new File("src3/day170601/test/IOTest.java");
		FileReader fr = null;
		try {
			//搭建文件与程序的管道
			fr = new FileReader(file);
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
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test3(){
		//文件介质
		File file = new File("src3/day170601/test/IOTest.java");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			char[] cs = new char[8192];
			try {
				fr.read(cs,10,23);//一次性将文件读到cs数组:10代表开始读入的位置，23代表读入的字节数
//				int mark = 0;
				/*while((mark = fr.read())!=-1){
					System.out.print((char)mark);
				}*/
				
				for (char c : cs) {
					System.out.print(c);
				}
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test4(){
		//文件介质
		File file = new File("src3/day170601/test/a.txt");
		
		//搭建文件与程序连接的管道
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(file);
			try {
				while(fs.available()>0){
					System.out.print((char)fs.read());
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
	
	//@Test
	public void test5() throws Exception{
		//输出流
		//将文件内容读入程序
		File rFile = new File("src3/day170601/test/IOTest.java");
		FileInputStream fs = null;
		fs = new FileInputStream(rFile);
		byte[] bs = new byte[(int)rFile.length()];
		fs.read(bs);
		fs.close();
		//将程序的内容写到文件中
		
		File wFile = new File("src3/day170601/test/IOTest.java.bak");
		FileOutputStream fos = null;
		fos = new FileOutputStream(wFile);
		
		fos.write(bs);
		fos.close();
	}
	@Test
	public void test6(){
		//将文件读入程序中
		//文件介质
		File rfile = new File("src3/day170601/test/IOTest.java");
		FileInputStream fs = null;
		byte[] bs = null;
		try {
			fs = new FileInputStream(rfile);
			bs = new byte[(int)rfile.length()];
			try {
				fs.read(bs);
				
				for (byte b : bs) {
					System.out.print(b);
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
		
		//将程序中的内容写到文件中
		//文件介质
		File wfile = new File("src3/day170601/test/IOTest.java.bak");//.bak:备份文件
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(wfile);
			try {
				fos.write(bs);
				for (byte b : bs) {
					System.out.print(b);
				}
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
