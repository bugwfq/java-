package IOStream.day170602.work;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1() throws IOException{
		File file = new File("src3/day170602/work/a.txt");
		FileInputStream fi = new FileInputStream(file);
		BufferedInputStream bs = new BufferedInputStream(fi,4);
		System.out.println(bs.markSupported());  
		bs.mark(3);
		
		System.out.println((char)bs.read());
		System.out.println((char)bs.read());
		System.out.println((char)bs.read());
		System.out.println((char)bs.read());
		bs.reset();
		System.out.println((char)bs.read());
		System.out.println((char)bs.read());
		System.out.println((char)bs.read());
		System.out.println((char)bs.read());
		bs.close();
	}
	
	//@Test
	public void test2(){
		byte[] bt = {97,98,99,100,101,102,103,104,105};
		ByteArrayInputStream bs = new ByteArrayInputStream(bt);
		int mark = 0;
		while((mark=bs.read())!=-1){
			System.out.print((char)mark);
		}
		try {
			bs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//@Test
	public void test3(){

		ByteArrayOutputStream bs = null;
		bs = new ByteArrayOutputStream();
		bs.write(97);
		bs.write(98);
		bs.write(99);
		bs.write(100);
		
		/*byte[] bt = bs.toByteArray();//将写入数组输出流的内容放入byte数组中
		for (byte b : bt) {
			System.out.println((char)b);
		}*/
		
		
		/*byte[] bt = {97,98,99,100,101,102,103,104,105};
		try {
			bs.write(bt);
		} catch (IOException e) {
			System.out.println("IO读写异常");
		}
		
		
		try {
			String str = bs.toString("utf-8");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			System.out.println("编码不支持");
		}*/
		
		File file = new File("src3/day170602/work/b.txt");
		FileOutputStream fot = null;
		try {
			fot = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}
		try {
			bs.writeTo(fot);//将此数组输出流的内容写到指定输出流
		} catch (IOException e) {
			System.out.println("IO读写异常");
		}finally{
			try {
				bs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test4(){
		char[] cs = {'a','b','c','d','e','f','g'};
		CharArrayReader cr = new CharArrayReader(cs);
		int mark = 0;
		try {
			while((mark=cr.read())!=-1){
				System.out.print((char)mark);
			}
		} catch (IOException e) {
			System.out.println("IO读写异常");
		}finally{
			cr.close();
		}
	}
	
	@Test
	public void test5(){
		char[] cs = {'a','b','c','d','e','中'};
		CharArrayWriter cw = new CharArrayWriter();
		try {
			cw.write(cs);
		} catch (IOException e) {
			System.out.println("IO读写异常");
		}
		
		/*char[] newC = cw.toCharArray();
		for (char c : newC) {
			System.out.print(c);
		}*/
		cw.reset();
		cw.append('国');
		cw.append('f');
		String s = cw.toString();
		System.out.println(s);
	}
	
	
}
