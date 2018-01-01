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
		
		/*byte[] bt = bs.toByteArray();//��д����������������ݷ���byte������
		for (byte b : bt) {
			System.out.println((char)b);
		}*/
		
		
		/*byte[] bt = {97,98,99,100,101,102,103,104,105};
		try {
			bs.write(bt);
		} catch (IOException e) {
			System.out.println("IO��д�쳣");
		}
		
		
		try {
			String str = bs.toString("utf-8");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			System.out.println("���벻֧��");
		}*/
		
		File file = new File("src3/day170602/work/b.txt");
		FileOutputStream fot = null;
		try {
			fot = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}
		try {
			bs.writeTo(fot);//�������������������д��ָ�������
		} catch (IOException e) {
			System.out.println("IO��д�쳣");
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
			System.out.println("IO��д�쳣");
		}finally{
			cr.close();
		}
	}
	
	@Test
	public void test5(){
		char[] cs = {'a','b','c','d','e','��'};
		CharArrayWriter cw = new CharArrayWriter();
		try {
			cw.write(cs);
		} catch (IOException e) {
			System.out.println("IO��д�쳣");
		}
		
		/*char[] newC = cw.toCharArray();
		for (char c : newC) {
			System.out.print(c);
		}*/
		cw.reset();
		cw.append('��');
		cw.append('f');
		String s = cw.toString();
		System.out.println(s);
	}
	
	
}
