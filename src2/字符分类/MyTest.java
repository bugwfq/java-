package �ַ�����;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		/**
		 * 4.�����ַ��������ڿ���̨��ˮ��������һ���ַ�������ĸ�����֡������ַ����ֿ���ӡ������̨��
		 * �������롱abcDEF123!@#��,��ô�������н��Ϊ��
		 * ��ĸ:abcDEF
		 * ����:123
		 *�����ַ�:!@#
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�");
		String s = sc.next();
		//��ĸ
		char[] c = s.toCharArray();
		System.out.println("��ĸ��");
		for(int i=0;i<s.length();i++){
			if(Character.isLetter(c[i])){
				System.out.print(c[i]+"");
			}
		}
		//����
		System.out.println();
		System.out.println("����:");
		for(int i=0;i<s.length();i++){
			if(Character.isDigit(c[i])){
				System.out.print(c[i]+"");
			}
		}
		//�����ַ�
		System.out.println();
		System.out.println("�����ַ�:");
		for(int i=0;i<s.length();i++){
			if(Character.isLetterOrDigit(c[i])==false && Character.isJavaIdentifierStart(c[i])==false){
				System.out.print(c[i]+"");
			}
		}
	}
}
