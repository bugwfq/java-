package day170401StringBuffer.work;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		MyStringBuffer ms = new MyStringBuffer("hello world");
		System.out.println(ms.append(false));//�� boolean �������ַ�����ʾ��ʽ׷�ӵ����� 
		System.out.println(ms.append('H'));//�� char �������ַ�����ʾ��ʽ׷�ӵ������� 
		System.out.println(ms.capacity());//���ص�ǰ����
		System.out.println(ms.delete(2, 6));//�Ƴ������е����ַ����е��ַ�
		char[] c = {'F','A','D'};
		System.out.println(ms.insert(2,c ));//�� char ����������ַ�����ʾ��ʽ�����������
		System.out.println(ms.reverse());// �����ַ��������䷴ת��ʽȡ��
		
		
		
	}
	
}
