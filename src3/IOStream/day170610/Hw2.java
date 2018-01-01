package IOStream.day170610;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class Hw2 {
	/**
	 * 2.�ڿ���̨����һ���ַ�����Ȼ������࣬�������ĸ��Сд֮���ת����ͨ��File
	 * ���󴴽���ͬ���͵��ļ���Ȼ�������ݱ�������ͬ���ļ�. 
	 * @throws IOException 
	 */
	@Test
	public void test() throws IOException{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		StringBuilder digit = new StringBuilder();
		StringBuilder lower = new StringBuilder();
		StringBuilder upper = new StringBuilder();
		StringBuilder java = new StringBuilder();
		StringBuilder others = new StringBuilder();
		
		//���ַ���ת��Ϊ����
		char[] cs = str.toCharArray();
		//��������
		for (char c : cs) {
			if(Character.isDigit(c)){
				digit.append(c);//����
			}else if(Character.isLowerCase(c)){
				lower.append(Character.toUpperCase(c));//Сдת��д
			}else if(Character.isUpperCase(c)){
				upper.append(Character.toLowerCase(c));//��дתСд
			}else if(Character.isJavaIdentifierStart(c)){
				java.append(c);//java��ʾ��
			}else{//�Ƿ��ַ�
				others.append(c);				
			}
		}
		
		//�����ݴ����Ӧ���ļ�
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2digit.txt")));
		bw.append(digit);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2lower.txt")));
		bw.append(lower);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2upper.txt")));
		bw.append(upper);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2java.txt")));
		bw.append(java);
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/hw2others.txt")));
		bw.append(others);
		bw.flush();
		
		bw.close();
	}
}
