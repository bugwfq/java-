package IOStream.day170610.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		//���ַ���ת��������
		char[] cs = str.toCharArray();
		//��������
		for (char c : cs) {
			if(Character.isDigit(c)){//����
				digit.append(c);
			}else if(Character.isLowerCase(c)){//Сд��ĸ
				lower.append(Character.toUpperCase(c));//Сд��ĸת�ɴ�д
			}else if(Character.isUpperCase(c)){//��д��ĸ
				upper.append(Character.toLowerCase(c));//��д��ĸת��Сд
			}else if(Character.isJavaIdentifierPart(c)){
				java.append(c);
			}else{
				others.append(c);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/digit.txt")));
		bw.append(digit);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/lower.txt")));
		bw.append(lower);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/upper.txt")));
		bw.append(upper);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/java.txt")));
		bw.append(java);
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170610/test1/others.txt")));
		bw.append(others);
		bw.close();
	}
}
