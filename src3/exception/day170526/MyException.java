package exception.day170526;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * * throws:�����׳��쳣
 * try:Ԥ���п��ܳ����쳣�Ĵ���
 * catch:����Ԥ�����ֵ��쳣
 * @author Administrator
 *
 */
public class MyException {	
	public static void main(String[] args)throws FileNotFoundException,IOException{		
		fun();
		fun1();
	}
	
	private static void fun() throws FileNotFoundException, IOException{
		Properties p = new Properties();
		p.load(new FileInputStream("src\\dj\\kodi.djig"));		
		System.out.println("hello world");
	}

	private static void fun1(){
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("src\\dj\\kodi.djig"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("hello world");
	}
}

