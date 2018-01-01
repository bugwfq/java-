package IOStream.day170610;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class Hw4 {
/**
 * 4.��d:�������ô������ɸ�һ��system.txt�ļ�,�����������ı�,����
	print the system
	��ͨ���
	exception
	ͨ��System���in�ض���,�ӿ���̨��ȡ���system.txt�ļ�,�����ò��Ѷ�ȡ
�����ļ�������System��out�ض��������d:/out.txt�ļ���,����ȡ��exception��ʱ��
,���׳�һ���Զ����쳣,�쳣�Ĵ������Ϣ��:"�����Զ�����쳣",������쳣��Ϣͨ��
System��err���ض��������d:/error.txt�ļ�
	(����:File,�Զ����쳣,System�����in ,out ,err�ض�
��,PrintStream,Writer,FileWriter)

 */
	
	@Test
	public void test1(){
		try {
			test();
		} catch (FileNotFoundException e) {
			try {
				System.setErr(new PrintStream(new File("src3/IO��/day170610/err.txt")));
				System.err.println(e.getMessage());
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test() throws FileNotFoundException{
	
		PrintWriter pw = new PrintWriter(new File("src3/IO��/day170610/system.txt"));
		pw.println("print the system");
		pw.println("��ͨ���");
		pw.println("exception");
		pw.flush();
		pw.close();
		
		System.setIn(new FileInputStream(new File("src3/IO��/day170610/system.txt")));
		System.setOut(new PrintStream(new File("src3/IO��/day170610/out.txt")));
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			String str = sc.next();
			System.out.print(str);
			
			if(str.equals("exception")){
				throw new MyException("�Զ����쳣");
			}
		}
		
	}
}
