package exception.day170528;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.management.RuntimeErrorException;
/**
 * 3.1 ����catch Exception,����catch������쳣(FileNotFoundException,IOException)
 * 3.2 ����Ϊ��ʹ���쳣��ʹ���쳣
 * 3.3 ����ʹ�ù����try��.
 * 3.4 �����쳣�����¼��־��Ȼ�������ܺ����쳣��
 * @param i
 */

public class ThrowTest {
	public static void main(String[] args) {
		try{
			fun(0);
		}catch (RuntimeException e) {
			//��ʾ�û�
			System.out.println("ϵͳ����ά��������ϵ����Ա������");
			//ͨ���ʼ����������쳣��Ϣ���͸���дfun�����ĳ���Ա
		}
	}

	private static void fun(int i){
		System.out.println("1");
		System.out.println("2");
		try{
			System.out.println(1/0);
			
		}catch (ArithmeticException e) {
			//��ԭʼ���쳣��Ϣ����
			try {
				e.printStackTrace(new PrintStream(new File("src3/day170528/err.log")));
				throw new RuntimeException("������־·���쳣");
			} catch (FileNotFoundException e1) {
			
				System.out.println("������־·���쳣");
			}
		}
		System.out.println("3");
	}
}
