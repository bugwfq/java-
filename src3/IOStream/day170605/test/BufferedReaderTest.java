package IOStream.day170605.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class BufferedReaderTest {
	//@Test
	public void test1()throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("src3/day170605/test/BufferedReaderTest.java")));
		String str = null;
		while((str=br.readLine())!=null){
			System.out.println(str);

		}
		br.close();
		
	}
	
	//@Test
	public void test()throws Exception{
		//���ֽ���ת�����ַ���
		InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("src3/day170605/test/BufferedReaderTest.java")));
		//�û�������װ�ַ���
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
	}
}
