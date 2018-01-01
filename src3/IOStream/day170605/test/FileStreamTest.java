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
		//�ļ�����
		File file = new File("src3/day170605/test/FileStreamTest.java");
		//���ļ����������(���ļ��е����ݶ��뵽����)
		FileInputStream fs = null;//�ֽ���
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
	
	@Test
	public void test2() {
		//�ַ���
		try {
			FileReader fr = new FileReader(new File("src3/day170605/test/FileStreamTest.java"));
			int mark = 0;
			try {
				while((mark=fr.read())!=-1){
					System.out.print((char)mark);
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}
		
	}
}
