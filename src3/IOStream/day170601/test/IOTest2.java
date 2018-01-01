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
		//�ֽ���
		//���ļ����ʶ��뵽����
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
				System.out.println("IO��д�쳣");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
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
		//�ַ���
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
				System.out.println("IO��д�쳣");
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
		 *  int read(char[] cbuf) ���ַ��������顣 
		 *  abstract  int read(char[] cbuf, int off, int len)  ���ַ����������ĳһ���֡� 
		 *  long skip(long n) �����ַ��� 
		 */
		
		File file = new File("src3/day170601/test/IOTest2.java");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
//			char[] cs = new char[(int)file.length()];
			try {
				//һ���Խ��ļ����ݶ���cs������
//				fr.read(cs/*,10,20*/);//���ļ��������(10:��ʼ��λ�ã�20�����������ֽ�)
				fr.skip(30);//����30���ֽڲ���
				int mark = 0;
				while((mark=fr.read())!=-1){
					System.out.print((char)mark);
				}
//				for (char c : cs) {
//					System.out.print(c);
//				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
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
		//���ļ����ݶ��������
		File rfile = new File("src3/day170601/test/IOTest2.java");
		FileInputStream fs = null;
		byte[] bs = null;
		try {
			fs = new FileInputStream(rfile);
			bs = new byte[(int)rfile.length()];
			try {
				fs.read(bs);
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//�������е�����д���ļ���
		File wfile = new File("src3/day170601/test/IOTest2.java.bak");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(wfile);
			try {
				fos.write(bs);
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}
		
	}
	
	//@Test
	public void test6() throws FileNotFoundException{
		
		File file = new File("src3/day170601/test/IOTest2.java.bak");
		//�ڵ�����ֱ�����������
		FileInputStream fs = new FileInputStream(file);
		
		//��������һ����װ�ڵ���!!!
		BufferedInputStream bs = new BufferedInputStream(fs);
	}
	

}
