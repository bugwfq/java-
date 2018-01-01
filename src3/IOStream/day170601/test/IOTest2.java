package IOStream.day170601.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferUnderflowException;

import org.junit.Test;

public class IOTest2 {
	//@Test
	public void test1(){
		//字节流
		//从文件介质读入到程序
		File file = new File("src3/day170601/test/IOTest2.java");
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
		File file = new File("src3/day170601/test/IOTest2.java");
		FileReader fr = null;
		try {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		/**
		 *  int read(char[] cbuf) 将字符读入数组。 
		 *  abstract  int read(char[] cbuf, int off, int len)  将字符读入数组的某一部分。 
		 *  long skip(long n) 跳过字符。 
		 */
		
		File file = new File("src3/day170601/test/IOTest2.java");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
//			char[] cs = new char[(int)file.length()];
			try {
				//一次性将文件内容读到cs数组中
//				fr.read(cs/*,10,20*/);//将文件读入程序(10:开始的位置，20代表读入多少字节)
				fr.skip(30);//跳过30个字节不读
				int mark = 0;
				while((mark=fr.read())!=-1){
					System.out.print((char)mark);
				}
//				for (char c : cs) {
//					System.out.print(c);
//				}
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
	public void test4() throws Exception{
		File file = new File("src3/day170601/test/IOTest2.java");
		FileInputStream fs = new FileInputStream(file);
		while(fs.available()>0){
			System.out.print((char)fs.read());
		}
		fs.close();
		
	}
	
	@Test
	public void test5(){
		//将文件内容读入程序中
		File rfile = new File("src3/day170601/test/IOTest2.java");
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
		
		
		//将程序中的内容写到文件中
		File wfile = new File("src3/day170601/test/IOTest2.java.bak");
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
		}
		
	}
	
	//@Test
	public void test6() throws FileNotFoundException{
		
		File file = new File("src3/day170601/test/IOTest2.java.bak");
		//节点流，直接与介质连接
		FileInputStream fs = new FileInputStream(file);
		
		//处理流，一定包装节点流!!!
		BufferedInputStream bs = new BufferedInputStream(fs);
	}
	

}
